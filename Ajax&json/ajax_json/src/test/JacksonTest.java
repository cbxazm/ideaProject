package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class JacksonTest {
    //java对象转为json字符串
    @Test
    public void test1() throws IOException {
        //创建person对象
        Person p=new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        //创建jackson的核心对象 ObjectMapper
        ObjectMapper mapper=new ObjectMapper();
        //转换
        /*
              writevalue(参数1,obj)
                 参数1：
                 File:将obj对象转换为json字符串，并且保存到指定的文件中
                 writer：将obj对象转换为json字符串，并将json数据填充到字符输出流中、
                 Outputstream:将obj对象转换为json字符串，并将json数据填充到字节输出流中、
              writevalueAsString(obj):将对象转为json字符串
         */
        String json = mapper.writeValueAsString(p);
//        System.out.println(json);
        //将数据写到d://json.txt文件下去
//         mapper.writeValue(new File("d://json.txt"),p);
                    //将数据关联到writer中
        mapper.writeValue(new FileWriter("d://json2.txt"),p);
    }
    @Test
    public  void test2() throws JsonProcessingException {
        //创建person对象
        Person p=new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(p);
        System.out.println(json);
    }
    /*
    演示json数据转为java对象
     */
    @Test
    public  void test3() throws IOException {
        //初始化json字符串
   String json="{\"gender\":\"男\",\"name\":\"张三\",\"age\":15}";

        //创建objectMapper
        ObjectMapper mapper =new ObjectMapper();
        //将java 转为perso对象
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);
    }
}
