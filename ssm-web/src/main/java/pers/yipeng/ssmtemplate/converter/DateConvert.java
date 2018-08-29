package pers.yipeng.ssmtemplate.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateConvert
 * @Description TODO
 * @Author eooy
 * @Date 2018/7/4 16:45
 * @Version 1.0
 **/
public class DateConvert implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parse = simpleDateFormat.parse(source);
            return parse;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
