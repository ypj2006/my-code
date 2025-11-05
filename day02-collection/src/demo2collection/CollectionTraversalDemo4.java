package demo2collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTraversalDemo4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Java入门");
        list.add("宁夏枸杞");
        list.add("黑枸杞");
        list.add("人字拖");
        list.add("特级枸杞");
        list.add("枸杞子");
        list.add("西洋参");
//        for (int i = 0; i < list.size(); i++){
//            String name = list.get(i);
//            if (name.contains("枸杞")){
//                list.remove(name);
//                i--;
//            }
//        }
//        System.out.println(list);


//        for(int i = list.size()-1; i >= 0; i--){
//            String name = list.get(i);
//            if (name.contains("枸杞")){
//                list.remove(name);
//            }
//        }
//        System.out.println(list);

        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String name = it.next();
            if (name.contains("枸杞")){
                it.remove();
            }
        }
        System.out.println(list);
    }
}
