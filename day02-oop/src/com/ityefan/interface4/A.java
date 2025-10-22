package com.ityefan.interface4;

public interface A {
    //默认用public修饰
    default void methodA() {
        System.out.println("methodA");
        methodB();
    }
    private void methodB() {
        System.out.println("methodB");
    }
    static void methodC() {
        System.out.println("methodC");
    }
}
