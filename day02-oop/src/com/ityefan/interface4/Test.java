package com.ityefan.interface4;

public class Test {
    public static void main(String[] args) {
        AImpl a = new AImpl();
        a.methodA();
        A.methodC();
    }
}
class AImpl implements A {

}