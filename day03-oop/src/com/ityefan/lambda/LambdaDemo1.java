package com.ityefan.lambda;

public class LambdaDemo1 {
    public static void main(String[] args) {
        Animal a = new Animal(){
            @Override
            public void cry(){
                System.out.println("猫是喵喵叫");
            }
        };
        a.cry();
        Swim s1 = () -> {
            System.out.println("他游泳贼快");
        };
        s1.swim();

    }
    public abstract static class Animal {
        public abstract void cry();
    }
    @FunctionalInterface
    interface Swim {
        void swim();
    }
}
