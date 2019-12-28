package com.cbx.proxy;

import com.cbx.cfg.Mapper;
import com.cbx.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    //map的key是全限定类名+方法名
    private Map<String,Mapper> mappers;
    private Connection conn;
    public MapperProxy(Map<String,Mapper> mappers,Connection conn){
             this.mappers=mappers;
             this.conn=conn;
    }
    /**
     * 用于对方法进行增强
     *我们的增强其实就是调用selectList方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
             //获取方法名
        String methodName=method.getName();
        System.out.println(methodName);//findAll
          //获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
        System.out.println(className);//com.cbx.Dao.IUserDao
         //组合key
        String key=className+"."+methodName;
        //获取mappers中的Mapper对象
        Mapper mapper = mappers.get(key);
        System.out.println(mapper);//com.cbx.cfg.Mapper@2cfb4a64
        //判断是否有mapper
        if(mapper==null){
                 throw new IllegalArgumentException("传入的参数有误");
        }
        //调用工具类执行查询所有(Executor)
            return new Executor().selectList(mapper,conn);
    }
}
