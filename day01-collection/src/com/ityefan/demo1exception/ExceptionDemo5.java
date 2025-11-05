package com.ityefan.demo1exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo5 {
    public static void main(String[] args){
        System.out.println("程序开始");
        try {
            show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("这次操作失败了!");
        }
        System.out.println("程序结束");
    }
    public static void show() throws Exception{
        //编译时异常，编译阶段报错，编译不通过
        String str = "2025-11-03 16:38:30";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(str);//编译时异常，提醒程序员这里的程序容易报错
        System.out.println(date);

        InputStream is = new FileInputStream("D:/a.png");
    }
}
