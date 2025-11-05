package demo2collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTraversalDemo2 {
    public static void main(String[] args) {
        Collection<String> names = new ArrayList<>();
        names.add("张三");
        names.add("李四");
        names.add("王五");
        names.add("赵六");

        for (String name : names){
            System.out.println(name);
        }
        String[] uesrs = {"张三","李四","王五","赵六"};
        for (String name : uesrs){
            System.out.println(name);
        }
    }
}
