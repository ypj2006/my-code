package com.ityefan.demo1map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTraverseDemo3 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("张三",18);
        map.put("王五",29);
        map.put("赵六",23);
        map.put("李四",18);
        map.put("赵六",20);
        Set<String> keys = map.keySet();
        for (String key : keys) {
            Integer value = map.get(key);
            System.out.println(key + "=" + value);
        }
    }
}
