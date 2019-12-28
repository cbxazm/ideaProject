package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

//利用选择器查询
public class JsoupDemo5 {
    public static void main(String[] args) throws IOException {
        String path=JsoupDemo5.class.getClassLoader().getResource("./xmla/student1.xml").getPath();
        Document document= Jsoup.parse(new File(path),"utf-8");
        //查询name标签
         Elements elements=document.select("name");
        System.out.println(elements);
        System.out.println("------");
        //查询id值为itcast的元素
        Elements elements1=document.select("#itcast");
        System.out.println(elements1);
        System.out.println("------");
        //获取student标签并且number为heima_0001
        Elements elements2=document.select("student[number='itcast_0001']");
        System.out.println(elements2);
        //获取student标签并且number为heima_0001的age子标签
        System.out.println("-------");
        Elements elements3=document.select("student[number='itcast_0001']>age");
        System.out.println(elements3);
    }

}
