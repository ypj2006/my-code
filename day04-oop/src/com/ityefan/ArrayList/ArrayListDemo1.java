package com.ityefan.ArrayList;

import java.util.ArrayList;

public class ArrayListDemo1 {
    public static void main(String[] args) {
        ArrayList< String> list = new ArrayList<>();
        list.add("张三");
        list.add("赵敏");
        list.add("王五");
        list.add("李四");
        System.out.println(list);

        System.out.println(list.get(0));
        System.out.println(list.get(1));

        for(int i = 0; i < list.size(); i++) System.out.println(list.get(i));

        list.remove(0);
        System.out.println(list);
        list.remove("王五");
        System.out.println(list);

        list.set(0,"王维");
        System.out.println(list);
    }
}
