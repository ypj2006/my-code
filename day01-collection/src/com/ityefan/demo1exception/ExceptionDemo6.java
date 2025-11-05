package com.ityefan.demo1exception;

import java.util.Scanner;

public class ExceptionDemo6 {
    public static void main(String[] args){
        while (true) {
            try {
                double price = userInputPrice();
                System.out.println("价格是："+price);
                break;
            } catch (Exception e) {
                System.out.println("输入价格有误，请重新输入！");
            }
        }
    }
    public static double userInputPrice(){
        System.out.println("请输入商品价格：");
        Scanner sc = new Scanner(System.in);
        double price = sc.nextDouble();
        return price;
    }
}
