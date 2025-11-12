package com.ityefan.demo1map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTraverseDemo4 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("张三",18);
        map.put("王五",29);
        map.put("赵六",23);
        map.put("李四",18);
        map.put("赵六",20);
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        for (Map.Entry<String,Integer> entry : entrySet) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "=" + value);
        }
    }
}
