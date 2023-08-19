package com.ymiir.myssm.utils;

public class StringJudge {
    public static boolean StringIsEmpty(String str){
        return str==null || "".equals(str);
    }
    public static boolean StringIsNotEmpty(String str){
        return !StringIsEmpty(str);
    }
}
