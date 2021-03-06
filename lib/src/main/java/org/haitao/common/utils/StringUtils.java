/* 
 * @(#)StringHelper.java    Created on 2013-3-14
 * Copyright (c) 2013 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package org.haitao.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
/**
 * 字符串一些工具类
 * @author wang  
 * @date 2016-3-31 下午5:00:40
 * @version V1.0
 */
public class StringUtils {


	/**
	 * 是不是空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(CharSequence str){
		if(null==str || "".equals(str.toString().trim())){
			return true;
		}
		return false;
	}

	/**
	 * 是不是空
	 * @param list
	 * @return
	 */
	public static boolean isEmpty(List list){
		if(null==list || list.size()==0){
			return true;
		}
		return false;
	}
    /**
     * bytes[]转换成Hex字符串,可用于URL转换，IP地址转换
     * @param bytes
     * @return
     */
    public static String bytesToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }
	/**
	 * @Description:hx 转换回来
	 * @param hexString
	 * @return byte[]
	 */
	public static byte[] hexStringToBytes(String hexString) {
		int len = hexString.length()/2;
		byte[] result = new byte[len];
		for (int i = 0; i < len; i++)
			result[i] = Integer.valueOf(hexString.substring(2*i, 2*i+2), 16).byteValue();
		return result;
	}

	/**
	 * 将Excepiton信息转换成String字符串.
	 * @param throwable
	 * @return
	 */
	public static String exceptionToString(Throwable throwable) {
        if (throwable == null) {
            return null;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            throwable.printStackTrace(new PrintStream(baos));
        }
        finally {
            try {
                baos.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
                System.gc();
            }
        }
        return baos.toString();
    }

    /** 
     * @Description:     生成随机数字和字母区分大小写  
     * @param @param     length
     * @return String    返回类型 
     */
     public static String getStringRandom(int length) {  
           
         String val = "";  
         Random random = new Random();  
           
         //参数length，表示生成几位随机数  
         for(int i = 0; i < length; i++) {  
               
             String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";  
             //输出字母还是数字  
             if( "char".equalsIgnoreCase(charOrNum) ) {  
                 //输出是大写字母还是小写字母  
                 int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;  
                 val += (char)(random.nextInt(26) + temp);  
             } else if( "num".equalsIgnoreCase(charOrNum) ) {  
                 val += String.valueOf(random.nextInt(10));  
             }  
         }  
         return val;  
     }  
     /** 
      * @Description:     生成随机字母区分大小写  
      * @param @param     length
      * @return String    返回类型 
      */
     public static String getStringRandomChar(int length) {  
     	
     	String val = "";  
     	Random random = new Random();  
     	//参数length，表示生成几位随机数  
     	for(int i = 0; i < length; i++) {  
     		int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;  
 			val += (char)(random.nextInt(26) + temp);  
     	}  
     	return val;  
     }  
     /** 
    * @Description: list 拼接成string
    * @param  list
    * @param  split
    * @return String    返回类型 
    */
    public static String ListToString(List<String> list,String split) {  
    	 if(list==null){
    		 return null;
    	 }
    	 StringBuilder sb = new StringBuilder();  
    	 //参数length，表示生成几位随机数  
    	 for(String ob:list) {  
    		sb.append(split).append(ob);
    	 }  
    	 return sb.toString().replaceFirst(split, "");  
     }  
    public static ArrayList<String> StrinToList(String strs,String split) {  
    	if(strs==null){
    		return new ArrayList<String>();
    	}
    	StringBuilder sb = new StringBuilder();  
    	//参数length，表示生成几位随机数  
    	String str[] =strs.split(split);
    	return new ArrayList<String>(Arrays.asList(str));  
    }  
    /** 
     * @Description: list 拼接成string
     * @param  object[]
     * @param  split
     * @return String    返回类型 
     */
    public static String ArrayToString(String object[],String split) {  
    	if(object==null){
    		return null; 
    	}
    	StringBuilder sb = new StringBuilder();  
    	//参数length，表示生成几位随机数  
    	for(Object ob:object) {  
    		sb.append(split).append(ob);
    	}  
    	return sb.toString().replaceFirst(split, "");  
    }  
    /** 
    * @Description: 
    * @param  object 原来的字符
    * @param  newObj 新的字符串
    * @param  split  分隔符
    * @return String    返回类型 
    */
    public static String StringToString(String object,String newObj,String split) {  
    	if(object==null || "" .equals(object)){
    		return newObj.toString(); 
    	}
    	object =object+split+newObj;
    	return object.toString();  
    }  
	/** 
	* @Description: 格式化数字
	* @param num
	* @return String    返回类型 
	*/
    public  static String formatUnit(int num){
		String numStr =String.valueOf(num);
		String numReslut =numStr;
		if(numStr.length()>3){
			DecimalFormat df = new DecimalFormat("#.0"); 
			if(numStr.length()<7){
				numReslut=df.format(num/1000.0).replaceAll("\\.0", "")+"k";
			}else {
				// 百万换
				numReslut=df.format(num/10000.0).replaceAll("\\.0", "")+"w";
			}
		}
		return numReslut;
		
	}
	/**
	 * 获取随机数
	 * @param min
	 * @param max
	 * @return
	 */
	public static int getRandom(int min,int max){
		 Random random = new Random();
		return random.nextInt(max)%(max-min+1) + min;
	}
	/**
	 * unicode 转字符串
	 */
	public static String unicode2String(String unicode) {
	 
	    StringBuffer string = new StringBuffer();
	 
	    String[] hex = unicode.split("\\\\u");
	 
	    for (int i = 1; i < hex.length; i++) {
	 
	        // 转换出每一个代码点
	        int data = Integer.parseInt(hex[i], 16);
	 
	        // 追加成string
	        string.append((char) data);
	    }
	 
	    return string.toString();
	}
	/**
	 * 字符串转换unicode
	 */
	public static String string2Unicode(String str) {
	 
//	    StringBuffer unicode = new StringBuffer();
//	 
//	    for (int i = 0; i < string.length(); i++) {
//	 
//	        // 取出每一个字符
//	        char c = string.charAt(i);
//	 
//	        // 转换为unicode
//	        unicode.append("\\u" + Integer.toHexString(c));
//	    }
//	 
//	    return unicode.toString();
		str = (str == null ? "" : str);
		String tmp;
		StringBuffer sb = new StringBuffer(1000);
		char c;
		int i, j;
		sb.setLength(0);
		for (i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			sb.append("\\u");
			j = (c >>> 8); // 取出高8位
			tmp = Integer.toHexString(j);
			if (tmp.length() == 1)
				sb.append("0");
			sb.append(tmp);
			j = (c & 0xFF); // 取出低8位
			tmp = Integer.toHexString(j);
			if (tmp.length() == 1)
				sb.append("0");
			sb.append(tmp);

		}
		return (new String(sb));
	}

	
}
