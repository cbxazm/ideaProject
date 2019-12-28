package com.Factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
public class BeanFactory {
    //定义一个Properties对象
    private static Properties props;
    //定义一个Map,用于存放我们要创建的对象，我们把它称为容器
    private static Map<String,Object> beans;
      //使用静态代码块为Properties对象赋值
    static {
        try {
              //实例化对象
            props=new Properties();
            //获取properties文件的流对象
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(inputStream);
            //实例化容器
            beans=new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                  //取出每一个key
                String key=keys.nextElement().toString();
                 //根据key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object instance = Class.forName(beanPath).newInstance();
                //把key和value存入容器中
                beans.put(key,instance);
            }
        }catch(Exception e){
            throw  new RuntimeException("初始化properties文件失败");
        }
      }
    /*
 改造getBean()方法
   */
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }
//      /*
//      根据bean的名称获取Bean对象
//       */
//      public static Object getBean(String beanName){
//          Object bean=null;
//            try{
//                String beanPath=props.getProperty(beanName);
////                System.out.println(beanPath);
//                bean=Class.forName(beanPath).newInstance();//每次都会调用默认构造函数创建对象
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//          return bean;
//      }
}
