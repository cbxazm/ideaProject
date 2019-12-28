package Test1;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18NTest {
    @Test
    public void test1(){
        //读取国际化资源数据
        //baseName=包名+文件名
        //默认读取的中文
        ResourceBundle bundle=ResourceBundle.getBundle("resources.message", Locale.US);
        System.out.println(bundle.getString("login.username"));

    }
}
