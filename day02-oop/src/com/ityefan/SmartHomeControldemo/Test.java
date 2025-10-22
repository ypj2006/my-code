package com.ityefan.SmartHomeControldemo;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        JD[] jds = new JD[4];
        jds[0] = new TV("小米电视", false);
        jds[1] = new Air("美的空调", true);
        jds[2] = new WashMachine("美的洗衣机", true);
        jds[3] = new Lamp("欧灯", false);
        SmartHomeControl smartHomeControl =SmartHomeControl.getInstance();
        //smartHomeControl.control(jds[0]);
        while(true) {
            smartHomeControl.printAllStatus(jds);
            System.out.println("请选择你要控制的设备：");
            Scanner sc = new Scanner(System.in);
            String command = sc.next();
            switch (command) {
                case "1":
                    smartHomeControl.control(jds[0]);
                    break;
                case "2":
                    smartHomeControl.control(jds[1]);
                    break;
                case "3":
                    smartHomeControl.control(jds[2]);
                    break;
                case "4":
                    smartHomeControl.control(jds[3]);
                    break;
                case "exit":
                    System.out.println("退出应用");
                    return;
                default:
                    System.out.println("输入有误，请重新输入");
                    break;
            }
        }
    }
}
