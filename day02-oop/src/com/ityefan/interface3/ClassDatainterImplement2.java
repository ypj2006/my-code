package com.ityefan.interface3;

public class ClassDatainterImplement2 implements ClassDatainter {
    private Student[] student;
    public ClassDatainterImplement2(Student[] student) {
        this.student = student;
    }
    @Override
    public void printAllStudentInfos() {
        System.out.println("全班信息如下：");
        int maleCount = 0;
        for(int j=0;j<student.length;j++) {
            Student s = student[j];
            System.out.println(s.getName() + " " + s.getSex() + " " + s.getScore());
            if (s.getSex() == "男") {
                maleCount++;
            }
        }
        System.out.println("男学生人数为："+maleCount);
        System.out.println("女学生人数为："+(student.length-maleCount));


    }

    @Override
    public void printAverageScore() {
        System.out.println("全班平均分如下：");
        Student s1 = student[0];
        double sum = s1.getScore();
        double max = s1.getScore();
        double min = s1.getScore();
        for(int j=0;j<student.length;j++) {
            Student s = student[j];
            sum = sum + s.getScore();
            if (s.getScore() > max) {
                max = s.getScore();
            }
            if (s.getScore() < min) {
                min = s.getScore();
            }
        }
        System.out.println("最高分为："+max);
        System.out.println("最低分为："+min);
        System.out.println("平均成绩为："+(sum-max-min)/student.length);
    }
}
