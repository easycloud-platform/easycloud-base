package cn.catbar.easycloud.common.utils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 时间格式类
 */
public class DateUtils {

    /**
     * YYYY-MM-DD格式
     */
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * YYYY-MM格式
     */
    private static SimpleDateFormat monthFormat = new SimpleDateFormat(
            "yyyy-MM");

    private static SimpleDateFormat bjSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 将Date转换成String
     */
    public static String dateToString(){
        // 北京
        bjSdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));  // 设置北京时区
        return  bjSdf.format(new Date());
    }

}

