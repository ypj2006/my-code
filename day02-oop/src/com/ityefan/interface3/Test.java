package com.ityefan.interface3;

public class Test {
    public static void main(String[] args) {
        Student[] allStudents = new Student[10];
        allStudents[0] = new Student("张三","男",100);
        allStudents[1] = new Student("李四","男",99);
        allStudents[2] = new Student("王五","男",98);
        allStudents[3] = new Student("张七","男",97);
        allStudents[4] = new Student("范八","女",96);
        allStudents[5] = new Student("彭九","男",95);
        allStudents[6] = new Student("赵二","男",94);
        allStudents[7] = new Student("韩七","女",93);
        allStudents[8] = new Student("马五","男",92);
        allStudents[9] = new Student("孙六","男",91);
        ClassDatainter cdi = new ClassDatainterImplement2(allStudents);
        cdi.printAllStudentInfos();
        cdi.printAverageScore();

    }
}
