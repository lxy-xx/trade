package com.safewind.methods;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zhh on 2018/4/22.
 */
public class Entryption {
   public Entryption(){

    }
public String md5password(String password){
    try {
        MessageDigest digest = MessageDigest.getInstance("md5");
        byte[] result = digest.digest(password.getBytes());
        StringBuffer buffer = new StringBuffer();
        String str;
        for (byte b : result) {
            int number = b & 0xff;
             str = Integer.toHexString(number);
            if (str.length() == 1) {
                buffer.append("0");
            }
            buffer.append(str);
        }
        return buffer.toString();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
        return "";
    }
}
public String md5prefix(String prefix,String password){
    try {
        MessageDigest digest =MessageDigest.getInstance("md5");
        prefix+=password;
        byte[] result =digest.digest(prefix.getBytes());
        StringBuffer buffer=new StringBuffer();
        for(byte b:result){
            int number=b&0xff;
            String str=Integer.toHexString(number);
            if(str.length()==1){
                buffer.append("0");
            }
            buffer.append(str);
        }
        return buffer.toString();
    }catch (NoSuchAlgorithmException e){
        e.printStackTrace();
        return "";
    }
}
}
