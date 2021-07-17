package com.pandy.base;

import lombok.val;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        Student studentA = new Student("张三", 25, "男");
        Student studentB = new Student("李四", 26, "男");
        Student studentC = new Student("小花", 27, "女");
        Student studentD = new Student("小明", 28, "男");
        Student studentE = new Student("小红", 29, "女");

        ArrayList<Student> class1Students = new ArrayList<>();
        class1Students.add(studentA);
        class1Students.add(studentB);
        class1Students.add(studentC);

        Class class1 = new Class("1801", class1Students);

        ArrayList<Student> class2Students = new ArrayList<>();
        class2Students.add(studentD);
        class2Students.add(studentE);

        Class class2 = new Class("1802", class2Students);

        HashMap<String, Class> hashMap = new HashMap<>();
        hashMap.put(class1.getClassName(), class1);
        hashMap.put(class2.getClassName(), class2);
        //方法1
        System.out.println("方法一-------------------------------------");
        for ( String s : hashMap.keySet() ) {
            ArrayList<Student> students = hashMap.get(s).getStudents();
            for ( Student student : students ) {
                System.out.println(student);
            }
        }
        //方法2
        System.out.println("方法二-------------------------------------");
        for (Class value : hashMap.values()) {
            ArrayList<Student> students = value.getStudents();
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
