package com.ityefan.interface3;

public class ClassDatainterImplement1 implements ClassDatainter {
    private Student[] student;
    public ClassDatainterImplement1(Student[] student) {
        this.student = student;
    }
    @Override
    public void printAllStudentInfos() {
        System.out.println("全班信息如下：");
        for (int i = 0; i < student.length; i++) {
            Student s = student[i];
            System.out.println(s.getName()+" "+s.getSex()+" "+s.getScore());
        }

    }

    @Override
    public void printAverageScore() {
        System.out.println("全班平均分如下：");
        double sum = 0;
        for (int i = 0; i < student.length; i++) {
            Student s = student[i];
            sum += s.getScore();
        }
        System.out.println("全班平均成绩额为："+sum/student.length);
    }
}
