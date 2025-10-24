package com.ityefan.method1reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Demo4 {
    public static void main(String[] args) {
//        CarFactory cf = new CarFactory() {
//            @Override
//            public Car getCar(String name) {
//                return new Car(name);
//            }
//        };
        //CarFactory cf = name ->  new Car(name);
        //构造器引用   类名::new
        CarFactory cf = Car::new;
        Car c1 = cf.getCar("奔驰");
        System.out.println(c1);
    }
}
@FunctionalInterface
interface CarFactory{
    Car getCar(String name);
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Car{
    private String name;
}