package cn.cbx.change;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToConverter implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        /**
         * 将字符串转为自定义的日期格式
         */
        if(s==null){
            throw  new RuntimeException("请您输入数据");
        }
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(s);
        } catch (ParseException e) {
           throw new RuntimeException("数据类型转换出现错误");
        }

    }
}
