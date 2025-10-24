package com.ityefan.method1reference;

import java.util.Arrays;
import java.util.Comparator;

public class Demo3 {
    static void main(String[] args) {
        String[] names = {"Jack","Tom","Mike","Andy","angela","Yefan","Rose","caocao"};
//        Arrays.sort(names,new Comparator<String>(){
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareToIgnoreCase(o2);
//            }
//        });
        //Arrays.sort(names,(o1,o2)->o1.compareToIgnoreCase(o2));
        //特定类方法引用 类型名称::方法名
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}
