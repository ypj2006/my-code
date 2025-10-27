package com.ityefan.StringDemo1;

import java.util.Scanner;

public class Stringdemo1 {
    public static void main(String[] args) {
        String s1 = "abc";
        System.out.println(s1);
        System.out.println(s1.length());

        String s2 = new String();
        System.out.println(s2);

        String s3 = new String("abc");
        System.out.println(s3);

        char[] chars = {'a', 'b', 'c'};
        String s4 = new String(chars);
        System.out.println(s4);

        byte[] bytes = {91, 92, 93, 94, 95, 96, 97, 98, 99, 89};
        String s5 = new String(bytes);
        System.out.println(s5);
        System.out.println("===================================");
        String t1 = "abc";
        String t2 = "abc";
        System.out.println(t1 == t2);

        String t3 = new String("abc");
        String t4 = new String("abc");
        System.out.println(t3 == t4);
        System.out.println("===================================");
        String okloginName = "admin";
        System.out.println("请输入登录密码：");
        Scanner sc = new Scanner(System.in);
        String loginName = sc.nextLine();
//         == 默认比较地址，字符串对象内容的比较一定不能用==，字符串内容一样地址不一定一样
//        if (loginName == okloginName){
//            System.out.println("登录成功");
//        }
//        else {
//            System.out.println("登录失败");
//        }
        if (loginName.equals(okloginName)) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
        System.out.println("===============================");
        String phoneNumber = "13453985301";
        String newPhoneNumber = phoneNumber.substring(0, 3) + "****" + phoneNumber.substring(7);
        System.out.println(newPhoneNumber);
    }
}
