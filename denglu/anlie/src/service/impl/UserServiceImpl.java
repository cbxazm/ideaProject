package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.User;
import service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService{
    private UserDao dao=new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用Dao来完成查询

        return dao.findAll();
    }
    public User login(User user){
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
         dao.update(user);
    }

    @Override
    public void delSelectedUser(String[] uids) {
        if(uids!=null&&uids.length>0){
            //遍历数组
            for (String id:uids){
                dao.delete(Integer.parseInt(id));
            }
        }

    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage=Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        //创建空的pageBean对象
        PageBean<User> pageBean=new PageBean<User>();
              //设置参数
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
           //调用dao查询总记录数
         int totalCount=dao.findTotalCount(condition);
         pageBean.setTotalCount(totalCount);
               //调用dao查询List集合
                    //先计算开始的记录索引
        int start=(currentPage-1)*rows;
        List<User> list=dao.findByPage(start,rows,condition);
        pageBean.setList(list);
        //计算总页码
        int totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1;
               pageBean.setTotalPage(totalPage);
        return pageBean;
    }

}
