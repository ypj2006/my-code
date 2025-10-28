package com.ityefan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    //包含ID，姓名，性别，年龄，电话，职位，薪资，入职日期，部门
    private int id;
    private String name;
    private String sex;
    private int age;
    private String phone;
    private String job;
    private double salary;
    private String entryDate;
    private String department;

}
