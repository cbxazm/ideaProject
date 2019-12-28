package jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;

/*
测试类
 */

public class JedisTest {
    @Test
        public  void test1(){
            /*
            获取连接
            操作
            关闭连接
             */
            Jedis jedis = new Jedis("localhost",6379);
            jedis.set("username","张三");
            jedis.close();
        }
        @Test
    public void test2(){
        /*
        操作字符串
         */
        //如果使用空构造函数，默认端口6379,ip为localhost
            Jedis jedis = new Jedis("localhost",6379);
            jedis.set("username","zhangsan");
            String username = jedis.get("username");
            System.out.println(username);
            //可以使用serex()方法存储可以指定过期时间的key value
            //该键值对active:hehe可以存储20秒后自动删除
            jedis.setex("active",20,"hehe");

            jedis.close();
        }
    @Test
    public void test3(){
        /*
        操作hash
         */
        //如使用空构造函数，默认端口6379,ip为localhost
        Jedis jedis = new Jedis("localhost",6379);
          jedis.hset("user","name","lisi");
          jedis.hset("user","age","23");
          jedis.hset("user","gender","male");
          //获取hash
        String name = jedis.hget("user", "name");
        System.out.println(name);
          //获取所有hash的值
        Map<String, String> user = jedis.hgetAll("user");
        Set<String> keySet = user.keySet();
        for(String key:keySet){
              //获取value
            String value = user.get(key);
            System.out.println(key+":"+value);
        }
        jedis.close();
    }
    @Test
    public void test4(){
        /*
        操作list
         */
        //如使用空构造函数，默认端口6379,ip为localhost
        Jedis jedis = new Jedis("localhost",6379);
        //从左边存
                    jedis.lpush("mylist","a","b","c");
                    //从右边存
                    jedis.rpush("mylist","a","b","c");
                    //范围获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        for(String value:mylist){
            System.out.println(value);
        }
        //list的弹出
        String s = jedis.lpop("mylist");
        System.out.println(s);


        jedis.close();
    }
    @Test
    public void test5(){
        /*
        操作set,不允许重复元素
         */
        //如使用空构造函数，默认端口6379,ip为localhost
        Jedis jedis = new Jedis("localhost",6379);
        jedis.sadd("myset","java","php","c++");
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);
        jedis.close();
    }
    @Test
    public void test6(){
        /*
        操作sortedset,不允许重复元素，且元素有序
         */
        //如使用空构造函数，默认端口6379,ip为localhost
        Jedis jedis = new Jedis("localhost",6379);
                   jedis.zadd("mysort",3,"yase");
                   jedis.zadd("mysort",5,"kai");
                   jedis.zadd("mysort",9,"houyi");
        Set<String> mysort = jedis.zrange("mysort", 0, -1);
        System.out.println(mysort);
        jedis.close();
    }
    @Test
    public  void test7(){
        //连接池使用
        //创建连接池对象
        //该构造方法有很多重载,参考jedis连接池配置
        JedisPool jedisPool=new JedisPool();
        //获取连接
        Jedis jedis = jedisPool.getResource();
        //使用
        jedis.set("heh","hah");
        //关闭(这个关闭本质是归还到连接池)
              jedis.close();
    }
}
