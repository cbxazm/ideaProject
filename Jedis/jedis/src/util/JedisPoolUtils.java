package util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
    工具类
    加载配置文件，配置连接池的参数
    提供获取连接的方法
 */
public class JedisPoolUtils {
         private static JedisPool jedisPool;
         static {
             //读取配置文件
             InputStream stream = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
             //创建properties对象
             Properties properties=new Properties();
             //关联文件
             try {
                 properties.load(stream);
             } catch (IOException e) {
                 e.printStackTrace();
             }
             //获取数据加载到JedisPoolConfig中
             JedisPoolConfig config=new JedisPoolConfig();
             config.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
             config.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
                  //初始化JedisPool
//             jedisPool=new JedisPool(config,Integer.parseInt(properties.getProperty(("host")),Integer.parseInt(properties.getProperty("port")));
             jedisPool = new JedisPool(config,properties.getProperty("host"),Integer.parseInt(properties.getProperty("port")));

         }
             public  static Jedis getJedis(){
                        return  jedisPool.getResource();
             }
}
