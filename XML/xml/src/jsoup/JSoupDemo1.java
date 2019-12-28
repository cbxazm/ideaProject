package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.File;
import java.io.IOException;


/*
jsoup的快速入门
 */
public class JSoupDemo1 {
    public static void main(String[] args) throws IOException {
        //获取document对象
         String path=JSoupDemo1.class.getClassLoader().getResource("./xmla/student1.xml").getPath();
          Document document=Jsoup.parse(new File(path),"utf-8");
        System.out.println(document);
          //获取元素对象
        Elements elements=document.getElementsByTag("name");//继承了arraylist
        System.out.println(elements.size());
        //获取第一个name的element
        Element element=elements.get(0);
        //获取数据
        String text=element.text();
        System.out.println(text);

    }
}
