package com.ityefan.abstractdemo1;

public abstract class A {

    private String name;
    private int age;
    public A(){

    }
    public A(String name, int age){
        this.name = name;
        this.age = age;
    }
    public abstract void method();
    public void method2(){
        System.out.println("普通方法");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
