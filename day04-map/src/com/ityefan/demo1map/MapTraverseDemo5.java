package com.ityefan.demo1map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class MapTraverseDemo5 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("张三",18);
        map.put("王五",29);
        map.put("赵六",23);
        map.put("李四",18);
        map.put("赵六",20);
//        map.forEach(new BiConsumer<String, Integer>() {
//            @Override
//            public void accept(String key, Integer value) {
//                System.out.println(key + "=" + value);
//            }
//        });
        map.forEach((k,v)->{System.out.println(k + "=" + v);});
    }
}
