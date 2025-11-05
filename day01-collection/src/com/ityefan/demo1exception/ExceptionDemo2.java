package com.ityefan.demo1exception;

public class ExceptionDemo2 {
    public static void main(String[] args) {
        System.out.println("程序开始");
        try {
            System.out.println(div(10, 0));
            System.out.println("底层方法执行成功了");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("底层方法执行失败了");
        }
        System.out.println("程序结束");
    }
    public static int div(int a,int b) throws Exception {
        if (b == 0){
            throw new Exception("除数不能为0");
        }
        int c = a/b;
        return c;
    }
}
