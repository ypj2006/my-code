package com.ityefan.demo1exception;

public class ExceptionDemo3 {
    public static void main(String[] args){
        System.out.println("程序开始");
        try {
            saveAge(100);
            System.out.println("成功了!");
        } catch (ItyefanAgeIllegalException e) {
            e.printStackTrace();
            System.out.println("失败了!");
        }
        System.out.println("程序结束");
    }
    public static void saveAge(int age) throws ItyefanAgeIllegalException {
        if(age < 0 || age > 200){
            throw new ItyefanAgeIllegalException("年龄不合法,不能低于一岁，不能高于两百岁");
        }
        else {
            System.out.println("年龄合法");
            System.out.println("保存年龄"+age);
        }
    }
}
