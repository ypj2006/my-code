package com.ityefan.demo1map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo2 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("张三",18);
        map.put("王五",29);
        map.put("赵六",23);
        map.put("李四",18);
        map.put("赵六",20);
        map.put(null,null);
        System.out.println(map);

        System.out.println(map.get("张三"));
        System.out.println(map.get("赵敏"));

        System.out.println(map.containsKey("张三"));
        System.out.println(map.containsKey("赵敏"));

        System.out.println(map.containsValue(18));
        System.out.println(map.containsValue(10));

        System.out.println(map.isEmpty());

        System.out.println(map.size());

        System.out.println(map.remove("张三"));

        map.clear();

        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();


    }
}
