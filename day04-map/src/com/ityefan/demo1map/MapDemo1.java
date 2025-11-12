package com.ityefan.demo1map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapDemo1 {
    public static void main(String [] args){
        //Map<String,Integer> map = new HashMap<>();
        Map<String,Integer> map = new LinkedHashMap<>();
        map.put("张三",18);
        map.put("王五",29);
        map.put("赵六",23);
        map.put("李四",18);
        map.put("赵六",20);
        map.put(null,null);
        System.out.println(map);
    }
}
