package com.ityefan.method1reference;

import java.util.Arrays;

public class Demo1 {
    static void main(String[] args) {
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
        //Arrays.sort(students,(o1, o2) -> o1.getAge()-o2.getAge());
        //Arrays.sort(students,(o1, o2) -> Student.compareByAge(o1,o2));
        //静态方法引用 类名::静态方法
        //前提:->前后参数的形式一致，才可以使用静态方法引用
        Arrays.sort(students,Student::compareByAge);

        for(int i = 0; i< students.length; i++){
            Student s = students[i];
            System.out.println(s);
        }
    }
}
