package com.xinyi_tech.commonlibs.util;

import android.content.Context;
import android.os.Environment;
import android.text.format.DateUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class StringUtil {
    private final static Pattern emailer = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
    private final static SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final static SimpleDateFormat dateFormater2 = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 将字符串转位日期类型
     * @param sdate
     * @return
     */
    public static Date toDate(String sdate) {
        try {
            return dateFormater.parse(sdate);
        } catch (ParseException e) {
            return null;
        }
    }


    /**
     * 判断是否数字
     * @param numbner
     * @return
     */
    public static boolean isNumber(String numbner){
        Pattern pattern =  Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(numbner);
        return matcher.matches();
    }


    /**
     * 以友好的方式显示时间
     * @param sdate
     * @return
     */
    public static String friendly_time(String sdate) {
        Date time = toDate(sdate);
        if(time == null) {
            return "Unknown";
        }
        String ftime = "";
        Calendar cal = Calendar.getInstance();

        //判断是否是同一天
        String curDate = dateFormater2.format(cal.getTime());
        String paramDate = dateFormater2.format(time);
        if(curDate.equals(paramDate)){
            int hour = (int)((cal.getTimeInMillis() - time.getTime())/3600000);
            if(hour == 0)
                ftime = Math.max((cal.getTimeInMillis() - time.getTime()) / 60000,1)+"分钟前";
            else
                ftime = hour+"小时前";
            return ftime;
        }

        long lt = time.getTime()/86400000;
        long ct = cal.getTimeInMillis()/86400000;
        int days = (int)(ct - lt);
        if(days == 0){
            int hour = (int)((cal.getTimeInMillis() - time.getTime())/3600000);
            if(hour == 0)
                ftime = Math.max((cal.getTimeInMillis() - time.getTime()) / 60000,1)+"分钟前";
            else
                ftime = hour+"小时前";
        }
        else if(days == 1){
            ftime = "昨天";
        }
        else if(days == 2){
            ftime = "前天";
        }
        else if(days > 2 && days <= 10){
            ftime = days+"天前";
        }
        else if(days > 10){
            ftime = dateFormater2.format(time);
        }
        return ftime;
    }

    /**
     * 判断给定字符串时间是否为今日
     * @param sdate
     * @return boolean
     */
    public static boolean isToday(String sdate){
        boolean b = false;
        Date time = toDate(sdate);
        Date today = new Date();
        if(time != null){
            String nowDate = dateFormater2.format(today);
            String timeDate = dateFormater2.format(time);
            if(nowDate.equals(timeDate)){
                b = true;
            }
        }
        return b;
    }

    /**
     * 判断给定字符串是否空白串。
     * 空白串是指由空格、制表符、回车符、换行符组成的字符串
     * 若输入字符串为null或空字符串，返回true
     * @param input
     * @return boolean
     */
    public static boolean isEmpty(String input )
    {
        if ( input == null || "".equals( input ) )
            return true;

        for ( int i = 0; i < input.length(); i++ )
        {
            char c = input.charAt( i );
            if ( c != ' ' && c != '\t' && c != '\r' && c != '\n' )
            {
                return false;
            }
        }
        return true;
    }


    /**
     *
     * @Title: empty
     * @Description: 判断所有对象是否为空
     * @param @param obj
     * @param @return    参数说明
     * @return boolean    返回类型
     * @throws
     */
    public static boolean isEmpty(Object obj)
    {
        if(null == obj)
        {
            return true;
        }
        else if((obj instanceof String) && "".equals(obj))
        {
            return true;
        }
        else if((obj instanceof Number) && ((Number) obj).doubleValue() == 0)
        {
            return true;
        }else if((obj instanceof Collection<?>) && ((Collection<?>) obj).isEmpty())
        {
            return true;
        }else if((obj instanceof Map<?,?>) && ((Map<?,?>) obj).isEmpty())
        {
            return true;
        }else if((obj instanceof Object[]) && ((Object[]) obj).length == 0)
        {
            return true;
        }
        return false;
    }

    public static String nullToString(String input){
        if(input==null){
            return "";
        }else{
            return input.trim();
        }
    }

    /**
     * 判断是不是一个合法的电子邮件地址
     * @param email
     * @return
     */
    public static boolean isEmail(String email){
        if(email == null || email.trim().length()==0)
            return false;
        return emailer.matcher(email).matches();
    }


    // 判断手机格式是否正确
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern
                .compile("^((13)|(15)|(18)|(17))\\d{9}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    // 判断固定电话格式是否0755
    public static boolean isPhone(String mobiles) {
        Pattern p = Pattern
                .compile("0755\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
    /**
     * 验证身份证号是否符合规则
     * @param text 身份证号
     * @return
     */
    public static boolean personIdValidation(String text) {
        String regx = "[0-9]{17}(x|X)";
        String reg1 = "[0-9]{15}";
        String regex = "[0-9]{18}";
        return text.matches(regx) || text.matches(reg1) || text.matches(regex);
    }

    /**
     * 字符串转整数
     * @param str
     * @param defValue
     * @return
     */
    public static int toInt(String str, int defValue) {
        try{
            return Integer.parseInt(str);
        }catch(Exception e){}
        return defValue;
    }
    /**
     * 对象转整数
     * @param obj
     * @return 转换异常返回 0
     */
    public static int toInt(Object obj) {
        if(obj==null) return 0;
        return toInt(obj.toString(),0);
    }
    /**
     * 对象转整数
     * @param obj
     * @return 转换异常返回 0
     */
    public static long toLong(String obj) {
        try{
            return Long.parseLong(obj);
        }catch(Exception e){}
        return 0;
    }
    /**
     * 字符串转布尔值
     * @param b
     * @return 转换异常返回 false
     */
    public static boolean toBool(String b) {
        try{
            return Boolean.parseBoolean(b);
        }catch(Exception e){}
        return false;
    }

    public static String arrayToString(ArrayList<String> arrayList){
        String str = "";
        for(int i=0;i<arrayList.size();i++){
            str += arrayList.get(i);
            if(i!=arrayList.size()-1){
                str += ",";
            }
        }
        return str;
    }


}