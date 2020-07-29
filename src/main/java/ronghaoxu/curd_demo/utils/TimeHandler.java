package ronghaoxu.curd_demo.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeHandler {
    private static final String timeFormatStr = "yyyy-MM-dd HH:mm:ss";

    private static final SimpleDateFormat sdf = new SimpleDateFormat(timeFormatStr);
    private static final DateFormat df = new SimpleDateFormat(timeFormatStr);

    //获取当前时间(sql.Timestamp)
    public static Timestamp currentTimestamp(){
        String temp = uDateToStr(new Date());
        return strToSqlTimestamp(temp);
    }

    //util.Date --> String
    @org.jetbrains.annotations.NotNull
    public static String uDateToStr(Date date){
        return sdf.format(new Date());
    }

    //String --> util.Date
    public static Date strToUDate(String strDate){
        Date date = null;

        try {
            date = sdf.parse(strDate);
        } catch (ParseException pe){
            pe.printStackTrace();
        }
        return date;
    }

    //sql.Timestamp --> String
    public static String sqlTimestampToStr(Timestamp stamp){
        return df.format(stamp);
    }

    //String --> sql.Timestamp
    public static Timestamp strToSqlTimestamp(String strDate){
        Date date = null;
        try {
            date = sdf.parse(strDate);
        } catch (ParseException pe){
            pe.printStackTrace();
        }
        assert date != null;
        return new Timestamp(date.getTime());
    }
}
