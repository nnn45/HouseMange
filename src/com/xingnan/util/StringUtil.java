package com.xingnan.util;

/**
 *  �ַ���������
 *
 * @author xingnan
 * @create 2023-12-14 19:49
 **/
public class StringUtil {
//    �ж��Ƿ�Ϊ��
    public static boolean isEmpty(String str){
        if (str == null || "".equals(str.trim())){
            return  true;
        }else {
            return false;
        }
    }
//    �ж��Ƿ�Ϊ��
    public static boolean isNotEmpty(String str){
    	
        if (str != null && !"".equals(str.trim())){
            return  true;
        }else {
            return false;
        }
    }




}
