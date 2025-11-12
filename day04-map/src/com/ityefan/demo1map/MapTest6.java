package com.ityefan.demo1map;

import java.util.*;

public class MapTest6 {
    public static void main(String[] args) {
        calc();
    }
    public static void calc(){
        List<String> locations = new ArrayList<>();
        String[] names = {"九龙山","长城","天安门","神潭大峡谷"};
        Random r = new Random();
        for (int i = 1; i <= 80; i++) {
            int index = r.nextInt(names.length);
            locations.add(names[index]);
        }
        System.out.println(locations);

        Map<String,Integer> map = new HashMap<>();
        for (String location : locations) {
            if (map.containsKey(location)) {
                map.put(location,map.get(location) + 1);
            }else{
                map.put(location,1);
            }
        }
        map.forEach((k,v)-> System.out.println(k + "被选择" + v +"次"));
    }
}
