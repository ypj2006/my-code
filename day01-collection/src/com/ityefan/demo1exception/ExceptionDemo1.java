package com.ityefan.demo1exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo1 {
    public static void main(String[] args) {
        //show();
        try {
            show2();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public static void show2() throws ParseException {
        System.out.println("程序开始");
        //编译时异常，编译阶段报错，编译不通过
        String str = "2025-11-03 16:38:30";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(str);//编译时异常，提醒程序员这里的程序容易报错
        System.out.println(date);
        System.out.println("程序结束");
    }
    public static void show(){
        System.out.println("程序开始");
        //运行异常，编译阶段不报错，运行阶段报错,继承自 RuntimeException
        int[] arr = {1,2,3};
        //System.out.println(arr[3]);//ArrayIndexOutOfBoundsException
        //System.out.println(10/0);//ArithmeticException
        //空指针异常
        String str = null;
        System.out.println(str);
        System.out.println(str.length());//NullPointerException
        System.out.println("程序结束");
    }
}
