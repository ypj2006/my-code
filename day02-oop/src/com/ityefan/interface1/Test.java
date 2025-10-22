package com.ityefan.interface1;

public class Test {
    public static void main(String[] args) {
        System.out.println(A.SHOOL_NAME);
        C c = new C();
        c.play();
        c.show();
    }
}
class C implements A, B {
    @Override
    public void show() {
        System.out.println("C类重写了show方法");
    }

    @Override
    public void play() {
        System.out.println("C类重写了play方法");
    }
}
