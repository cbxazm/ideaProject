package Convert;

import org.apache.struts2.util.StrutsTypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
public class MyDateConvert extends StrutsTypeConverter {
    @Override
    public Object convertFromString(Map context, String[] values, Class toClass) {
        //把字符串转为对象
//        System.out.println(toClass);//class java.util.Date
//        for(String s:values){
//            System.out.println(s);//输入的日期类型
//        }
             if(values!=null&&values.length>0){
                  String dateStr=values[0];
                  if("".equals(dateStr)){
                          return  null;
                  }
                  //转换
                 SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
                 try {
                     return  format.parse(dateStr);
                 } catch (ParseException e) {
                     e.printStackTrace();
                     throw new RuntimeException(e);//转换异常
                 }
             }
        return null;
    }
    @Override
    public String convertToString(Map context, Object o) {
        //把对象转为字符串
        return null;
    }
}
