package com.ityefan.interface2;

public class Test {
    public static void main(String[] args) {
        Driver a = new Student();
        Driver b = new Teacher();
        Boyfriend c = new Teacher();
    }
}
interface Driver {}
interface Boyfriend{}
class People{}
class Student extends People implements Driver,Boyfriend{}
class Teacher implements Driver,Boyfriend{}
