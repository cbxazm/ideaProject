package jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

/*
xpath查询
 */
public class JsoupDemo6 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        String path=JsoupDemo5.class.getClassLoader().getResource("./xmla/student1.xml").getPath();
        Document document= Jsoup.parse(new File(path),"utf-8");
             //根据document对象，创建JXDocument对象
        JXDocument jxDocument=new JXDocument(document);
         //结合xpath语法查询、
        //查询所有的student标签
        List<JXNode> jxNodes=jxDocument.selN("//student");
        for (JXNode jxNode:jxNodes){
            System.out.println(jxNode);
        }
        //查询所有student标签下的name标签
        System.out.println("-----");
        List<JXNode> jxNodes2=jxDocument.selN("//student/name");
        for (JXNode jxNode:jxNodes2){
            System.out.println(jxNode);
        }
        //查询student标签下带有name属性的标签
        System.out.println("------");
        List<JXNode> jxNodes3=jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode:jxNodes3){
            System.out.println(jxNode);
        }

    }
}
