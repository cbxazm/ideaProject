package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.File;
import java.io.IOException;

//Element对象的功能
public class JsoupDemo4 {
    public static void main(String[] args) throws IOException {
          String path=JsoupDemo4.class.getClassLoader().getResource("./xmla/student1.xml").getPath();
        Document document=Jsoup.parse(new File(path),"utf-8");
//        4. Element：元素对象
//        1. 获取子元素对象
//                * getElementById​(String id)：根据id属性值获取唯一的element对象
//                * getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
//                * getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
//                * getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合
//
//        2. 获取属性值
//                * String attr(String key)：根据属性名称获取属性值
//        3. 获取文本内容
//                * String text():获取文本内容
//                * String html():获取标签体的所有内容(包括字标签的字符串内容)
                  Elements elements=document.getElementsByTag("name");
                System.out.println(elements);
        System.out.println("----------");
           /*
           只想获取第一个name元素
            */
               Element element_student=document.getElementsByTag("student").get(0);
               Elements ele_name=element_student.getElementsByTag("name");
        System.out.println(ele_name);
        System.out.println("---------");
        /*
        获取element对象的属性值(这里不区分大小写)
         */
        String s=element_student.attr("number");
        System.out.println(s);
//        String s1=element_student.attr("id");
//        System.out.println(s1);
        System.out.println("-----");
         /*
    获取文本内容
     */
        String text=ele_name.text();//这个方法获取的纯文本
        System.out.println(text);
         ele_name.html();//如果下面还有标签，会全部获取
    }
    }

