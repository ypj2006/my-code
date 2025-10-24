package com.ityefan.method1reference;

import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        Student[] students = new Student[6];
        students[0] = new Student("张三",35,178,'男');
        students[1] = new Student("李四",28,175,'男');
        students[2] = new Student("王五",25,180,'男');
        students[3] = new Student("张七",32,172,'男');
        students[4] = new Student("范八",27,168,'女');
        students[5] = new Student("彭九",19,170,'男');
        Student s1 = new Student();
        //Arrays.sort(students,(o1,o2)->s1.compareByHeight(o1,o2));
        //实例方法引用 对象名::实例方法
        //前提:->前后参数的形式一致，才可以使用实例方法引用
        Arrays.sort(students,s1::compareByHeight);


        for(int i = 0; i< students.length; i++){
            Student s = students[i];
            System.out.println(s);
        }
    }
}
