package com.tiffany.phippy;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.icu.util.Calendar;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import org.json.JSONObject;

import java.lang.reflect.Field;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/**
 * Created by toby on 20/04/2017.
 */

public class CommonUtils {

    public static final int secondOfHour   =    60*60;
    public static final int secondOfDay    = 24*60*60;
    public static final String collection_userinfo_lasttime = "collection_userinfo_lasttime";


    public static String getCurrentSystemLanguage(Context context){
        Locale locale = context.getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        return language;
    }
    /**
     * 返回当前程序版本名
     */
    public static String getAppVersionName(Context context) {
        String versionName = "";
        int versioncode = 0;
        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            versioncode = pi.versionCode;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return versionName;
    }

    /**********************************************************************/
    // ip
    public static String getIPAddress(Context context) {
        NetworkInfo info = ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {//当前使用2G/3G/4G网络
                try {
                    //Enumeration<NetworkInterface> en=NetworkInterface.getNetworkInterfaces();
                    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                        NetworkInterface intf = en.nextElement();
                        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                            InetAddress inetAddress = enumIpAddr.nextElement();
                            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                                return inetAddress.getHostAddress();
                            }
                        }
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                }

            } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {//当前使用无线网络
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                String ipAddress = intIP2StringIP(wifiInfo.getIpAddress());//得到IPV4地址
                return ipAddress;
            }
        } else {
            //当前无网络连接,请在设置中打开网络
        }
        return null;
    }

    /**
     * 将得到的int类型的IP转换为String类型
     *
     * @param ip
     * @return
     */
    public static String intIP2StringIP(int ip) {
        return (ip & 0xFF) + "." +
                ((ip >> 8) & 0xFF) + "." +
                ((ip >> 16) & 0xFF) + "." +
                (ip >> 24 & 0xFF);
    }

    /**********************************************************************/


    /**
     * 版本号比较
     *
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) {
            return 0;
        }
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        Log.d("HomePageActivity", "version1Array=="+version1Array.length);
        Log.d("HomePageActivity", "version2Array=="+version2Array.length);
        int index = 0;
        // 获取最小长度值
        int minLen = Math.min(version1Array.length, version2Array.length);
        int diff = 0;
        // 循环判断每位的大小
        Log.d("HomePageActivity", "verTag2=2222="+version1Array[index]);
        while (index < minLen
                && (diff = Integer.parseInt(version1Array[index])
                - Integer.parseInt(version2Array[index])) == 0) {
            index++;
        }
        if (diff == 0) {
            // 如果位数不一致，比较多余位数
            for (int i = index; i < version1Array.length; i++) {
                if (Integer.parseInt(version1Array[i]) > 0) {
                    return 1;
                }
            }

            for (int i = index; i < version2Array.length; i++) {
                if (Integer.parseInt(version2Array[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            return diff > 0 ? 1 : -1;
        }
    }

    //把String转化为float
    public static float convertToFloat(String number, float defaultValue) {
        if (TextUtils.isEmpty(number)) {
            return defaultValue;
        }
        try {
            return Float.parseFloat(number);
        } catch (Exception e) {
            return defaultValue;
        }

    }

    //把String转化为double
    public static double convertToDouble(String number, double defaultValue) {
        if (TextUtils.isEmpty(number)) {
            return defaultValue;
        }
        try {
            return Double.parseDouble(number);
        } catch (Exception e) {
            return defaultValue;
        }

    }

    //把String转化为int
    public static int convertToInt(String number, int defaultValue) {
        if (TextUtils.isEmpty(number)) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            return defaultValue;
        }
    }

/////////////////////////////////////////////////////////////////////////


    //    px与dip的概念及互相转化
//    px即pixels，是绝对像素，有多少个像素点就是多少个像素点。
//    dip即device independent pixel，设备独立像素，无像素无关。
    public static float dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 获得状态栏的高度
     *
     * @param context
     * @return
     */
    public static float getStatusHeight(Context context) {

        int statusHeight = -1;
        try {
            Class clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }

    public static float getWindowWidth(Activity context){

        WindowManager wm = context.getWindowManager();
        return wm.getDefaultDisplay().getWidth();
    }
    public static float getWindowHeight(Activity context){

        WindowManager wm = context.getWindowManager();
        return wm.getDefaultDisplay().getHeight();
    }

    //生成唯一码
    public static String getUniquePsuedoID(){
        String m_szDevIDShort = "35" +

                //主板
                Build.BOARD.length() % 10   +

                //android系统定制商
                Build.BRAND.length() % 10   +

                //cpu指令集
                Build.CPU_ABI.length() % 10 +

                //设备参数
                Build.DEVICE.length() % 10  +

                //显示屏参数
                Build.DISPLAY.length() % 10 +
                Build.HOST.length() % 10    +

                //修订版本列表
                Build.ID.length() % 10      +

                //硬件制造商
                Build.MANUFACTURER.length() % 10 +

                //版本
                Build.MODEL.length() % 10   +

                //手机制造商
                Build.PRODUCT.length() % 10 +

                //描述build的标签
                Build.TAGS.length() % 10    +

                //builder类型
                Build.TYPE.length() % 10    +
                //
                Build.USER.length() % 10;

        String serial = Build.SERIAL;
        return new UUID(m_szDevIDShort.hashCode(),serial.hashCode()).toString();

    }

    //获得设备信息
    public static String collectDeviceInfo(Context ctx) {

        try {
            PackageManager pm = ctx.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(ctx.getPackageName(), PackageManager.GET_ACTIVITIES);
            if (pi != null) {
                String versionName = pi.versionName == null ? "null" : pi.versionName;
                String versionCode = pi.versionCode + "";
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("collect", "an error occured when collect package info", e);
        }
        Field[] fields = Build.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
//                infos.put(field.getName(), field.get(null).toString());
                Log.e("collectDeviceInfo", field.getName() + " : " + field.get(null));
            } catch (Exception e) {
                Log.e("collect", "an error occured when collect crash info", e);
            }
        }

        return Build.BRAND +"|" + Build.MODEL;

    }

    /**
     * 获取当前屏幕截图，包含状态栏
     *
     * @param activity
     * @return
     */
    public static Bitmap snapShotWithStatusBar(Activity activity)
    {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        int width = (int) getWindowWidth(activity);
        int height = (int) getStatusHeight(activity);
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, 0, width, height);
        view.destroyDrawingCache();
        return bp;

    }

    /**
     * 获取当前屏幕截图，不包含状态栏
     *
     * @param activity
     * @return
     */
    public static Bitmap snapShotWithoutStatusBar(Activity activity)
    {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;

        int width = (int) getWindowWidth(activity);
        int height = (int) getStatusHeight(activity);
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height
                - statusBarHeight);
        view.destroyDrawingCache();
        return bp;

    }


        public static Map<String, String> getMapForJson(String jsonStr){
        JSONObject jsonObject ;
        Map<String, String> valueMap = new HashMap<String, String>();
        try {
            jsonObject = new JSONObject(jsonStr);

            Iterator<String> keyIter= jsonObject.keys();
            String key;
            String value ;

            while (keyIter.hasNext()) {
                key = keyIter.next();
                value = (String) jsonObject.get(key);
                valueMap.put(key, value);
            }
            return valueMap;
        } catch (Exception e) {

            e.printStackTrace();

        }


       return valueMap;
    }

    /**************************   时间相关   **************************/

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static boolean isIntraday(Context context){
       long last_time = CommonUtils.getLong(context,CommonUtils.collection_userinfo_lasttime);
        long curDate =  System.currentTimeMillis();
//        Log.e("curDate", String.valueOf(curDate.getTime()/1000L + "|" + last_time));

        //毫秒
//        Log.e("curDate","Hellojni"+System.currentTimeMillis());
        Log.e("isIntraday","last_time:" + last_time + "  curDate:" + curDate/1000L);
        return curDate/1000L -last_time < CommonUtils.secondOfDay;
    }

    public static long getCurrentDate(){

//        SimpleDateFormat formatter   =   new   SimpleDateFormat   ("yyyy年MM月dd日   HH:mm:ss");
        Date curDate =  new Date(System.currentTimeMillis());

        return curDate.getTime()/1000L;
    }

    /***************    获取系统时间  某年 某月 某天 星期几    ***************/

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static int getYear(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return year;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static int getMonth(){
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.YEAR);
        return month;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static int getDay(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return day;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public static int getDayOfWeek(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;// Java月份从0开始算
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        calendar.set(Calendar.YEAR, year);//指定年份
        calendar.set(Calendar.MONTH, month - 1);//指定月份 Java月份从0开始算
        int daysCountOfMonth = calendar.getActualMaximum(Calendar.DATE);//获取指定年份中指定月份有几天

        //获取指定年份月份中指定某天是星期几
        calendar.set(Calendar.DAY_OF_MONTH, day);  //指定日
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        Log.e("calendar","year:"+year+" month:"+month+" day:"+day+" week:"+dayOfWeek);
//        String str = "";
//        switch (dayOfWeek)
//        {
//            case 1:
//                str = "星期日";
//                break;
//            case 2:
//                str ="星期一";
//                break;
//            case 3:
//                str = "星期二";
//                break;
//            case 4:
//                str ="星期三";
//                break;
//            case 5:
//                str ="星期四";
//                break;
//            case 6:
//                str = "星期五";
//                break;
//            case 7:
//                str ="星期六";
//                break;
//        }
//        return str;
        return dayOfWeek;
    }



    /****************************************************************************/

    /***********************   sharePreference 数据持久化   ***********************/

    public static String getString(Context context, String strKey) {
        SharedPreferences setPreferences = context.getSharedPreferences("app", 0);
        String result = setPreferences.getString(strKey, "");
        return result;
    }

    public static String getString(Context context, String strKey, String strDefault) {
        SharedPreferences setPreferences = context.getSharedPreferences("app", 0);
        String result = setPreferences.getString(strKey, strDefault);
        return result;
    }

    public static void saveString(Context context, String strKey, String strData) {
        SharedPreferences activityPreferences = context.getSharedPreferences("app", 0);
        SharedPreferences.Editor editor = activityPreferences.edit();
        editor.putString(strKey, strData);
        editor.commit();
    }

    public static Boolean getBoolean(Context context, String strKey) {
        SharedPreferences setPreferences = context.getSharedPreferences("app", 0);
        Boolean result = Boolean.valueOf(setPreferences.getBoolean(strKey, false));
        return result;
    }

    public static Boolean getBoolean(Context context, String strKey, Boolean strDefault) {
        SharedPreferences setPreferences = context.getSharedPreferences("app", 0);
        Boolean result = Boolean.valueOf(setPreferences.getBoolean(strKey, strDefault.booleanValue()));
        return result;
    }

    public static void saveBoolean(Context context, String strKey, Boolean strData) {
        SharedPreferences activityPreferences = context.getSharedPreferences("app", 0);
        SharedPreferences.Editor editor = activityPreferences.edit();
        editor.putBoolean(strKey, strData.booleanValue());
        editor.commit();
    }

    public static int getInt(Context context, String strKey) {
        SharedPreferences setPreferences = context.getSharedPreferences("app", 0);
        int result = setPreferences.getInt(strKey, -1);
        return result;
    }

    public static int getInt(Context context, String strKey, int strDefault) {
        SharedPreferences setPreferences = context.getSharedPreferences("app", 0);
        int result = setPreferences.getInt(strKey, strDefault);
        return result;
    }

    public static void saveInt(Context context, String strKey, int strData) {
        SharedPreferences activityPreferences = context.getSharedPreferences("app", 0);
        SharedPreferences.Editor editor = activityPreferences.edit();
        editor.putInt(strKey, strData);
        editor.commit();
    }

    public static long getLong(Context context, String strKey) {
        SharedPreferences setPreferences = context.getSharedPreferences("app", 0);
        long result = setPreferences.getLong(strKey, -1L);
        return result;
    }

    public static long getLong(Context context, String strKey, long strDefault) {
        SharedPreferences setPreferences = context.getSharedPreferences("app", 0);
        long result = setPreferences.getLong(strKey, strDefault);
        return result;
    }

    public static void saveLong(Context context, String strKey, long strData) {
        SharedPreferences activityPreferences = context.getSharedPreferences("app", 0);
        SharedPreferences.Editor editor = activityPreferences.edit();
        editor.putLong(strKey, strData);
        editor.commit();
    }

    /****************************************************************************/
}
