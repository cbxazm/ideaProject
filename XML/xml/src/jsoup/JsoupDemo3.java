package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

//Document/Element功能
public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
            String path=JsoupDemo3.class.getClassLoader().getResource("./xmla/student1.xml").getPath();
        Document document= Jsoup.parse(new File(path),"utf-8");
           Elements elements=document.getElementsByTag("student");
        System.out.println(elements);
        System.out.println("-------------");
           //获取属性名为id的元素
          Elements element=document.getElementsByAttribute("id");
        System.out.println(element);
        System.out.println("---------");
           Elements elements1=document.getElementsByAttributeValue("number","itcast_0001");
        System.out.println(elements1);
    }
}
