package dom4j;

import org.dom4j.Document;
import org.dom4j.Element;


public class TestDom4j1 {
    public static void main(String[] args) {
                  getValues();
    }
    //获取第一个p1里面的属性id1的值
    public  static  void  getValues(){
        Document document=Dom4jUtils.getDocumment(Dom4jUtils.PATH);
        Element element=document.getRootElement();
        //得到第一个P元素
        Element p1=element.element("p1");
        String value=p1.attributeValue("id1");
        System.out.println(value);
    }
}
