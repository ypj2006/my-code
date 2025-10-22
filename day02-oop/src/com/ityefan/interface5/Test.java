package com.ityefan.interface5;

public class Test {
    public static void main(String[] args) {
        C2 c2 = new C2();
        c2.methodA2();
    }
}
interface A3{
    default void methodA3(){
        System.out.println("A3");
    }
}
interface B3{
    default void methodA3(){
        System.out.println("B3");
    }
}
class C3 implements A3, B3{

    @Override
    public void methodA3() {
        System.out.println("C3");
        A3.super.methodA3();
        B3.super.methodA3();
    }
}







interface A2 {
    default void methodA2() {
        System.out.println("A2");
    }
}
class B2{
    public void methodA2() {
        System.out.println("B2");
    }
}
class C2 extends B2 implements A2 {}







interface A1 {
    void method();
}
interface B1 {
    String method();
}
//方法签名存在冲突,不能多继承也不能多实现
//interface c1 extends A1,B1 {}
//class D1 implements A1, B1 {
    //@Override
    //public void method() {}
//}



interface A {
     void methodA();
}
interface B {
    void methodB();
}
interface C extends A,B {
    void methodC();
}
class D implements C {

    @Override
    public void methodC() {

    }

    @Override
    public void methodA() {

    }

    @Override
    public void methodB() {

    }
}