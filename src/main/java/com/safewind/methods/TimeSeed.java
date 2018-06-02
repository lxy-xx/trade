package com.safewind.methods;

import java.util.Calendar;

/**
 * Created by zhh on 2018/4/22.
 */
public class TimeSeed {
    public String getCurrentTime(){
        Calendar now=Calendar.getInstance();
        StringBuffer sbuffer=new StringBuffer();
        sbuffer.append(now.get(Calendar.YEAR)).append(now.get(Calendar.MONTH)+1).append(now.get(Calendar.DAY_OF_MONTH));
        sbuffer.append(now.get(Calendar.HOUR_OF_DAY)).append(now.get(Calendar.MINUTE));
        int second=now.get(Calendar.SECOND);
        second=(second/5)*5;
        sbuffer.append(second);
        return sbuffer.toString();
    }
    //忽略分钟之前的
    public String getPreviousTime(){
        Calendar now=Calendar.getInstance();
        StringBuffer sbuffer=new StringBuffer();
        sbuffer.append(now.get(Calendar.YEAR)).append(now.get(Calendar.MONTH)+1).append(now.get(Calendar.DAY_OF_MONTH));
        int hour=now.get(Calendar.HOUR_OF_DAY);
        int minute=now.get(Calendar.DAY_OF_MONTH);
        int second=now.get(Calendar.SECOND);
        if(second<5&&minute==0) {
            sbuffer.append(hour - 1).append(59).append(55);
            return sbuffer.toString();
        }else{
            sbuffer.append(hour);
        }
        if(second<5){
            sbuffer.append(minute).append(55);
            return sbuffer.toString();
        }else{
            second=(second/5-1)*5;
            sbuffer.append(minute).append(second);
        }
        return sbuffer.toString();
    }
}
