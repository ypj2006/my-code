package com.ityefan.method1reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private int age;
    private double height;
    private char sex;
    public static int compareByAge(Student o1,Student o2){
        return o1.getAge()-o2.getAge();
    }
    public int compareByHeight(Student o1,Student o2){
        return Double.compare(o1.getHeight(),o2.getHeight());
    }
}
