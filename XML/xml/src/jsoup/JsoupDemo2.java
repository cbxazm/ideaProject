package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class JsoupDemo2 {
    public static void main(String[] args) {
        URL url;

        {
            try {
                url = new URL("https://www.baidu.com");
                Document document=Jsoup.parse(url,100000);
                System.out.println(document);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
