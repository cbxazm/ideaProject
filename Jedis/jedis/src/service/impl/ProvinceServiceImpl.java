package service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProvinceDao;
import dao.impl.ProvinceDaoImpl;
import domain.Province;
import redis.clients.jedis.Jedis;
import service.ProvinceService;
import util.JedisPoolUtils;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {

     private ProvinceDao dao=new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {
        /*
        使用redis的缓存
         */
        //从redis中查询数据，现货区客户端连接
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json=jedis.get("province");
        //判断
        if(province_json==null||province_json.length()==0){
              //redis中没有数据,从数据库中查询
            System.out.println("redis中没数据，查询数据库....");
              //从数据库中查询
            List<Province> all = dao.findAll();
            //将list序列化为json
            ObjectMapper mapper=new ObjectMapper();
            try {
                province_json=mapper.writeValueAsString(all);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //将json数据传入redis
            jedis.set("province",province_json);
            //归还连接
            jedis.close();
        }else {
            System.out.println("redis中有数据，查询缓存.....");
        }

        return province_json;
    }
}
