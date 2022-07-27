package com.pandy.algorithm.huawei.jishi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    public static final Comparator<Student> INCREASE = new increase();
    public static final Comparator<Student> DECREASE = new decrease();
    private final int grade;
    private final String name;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String toString() {
        return name + " " + grade;
    }

    private static class increase implements Comparator<Student> {
        public int compare(Student v, Student w) {
            return w.grade - v.grade;
        }
    }

    private static class decrease implements Comparator<Student> {
        public int compare(Student v, Student w) {
            return v.grade - w.grade;
        }
    }
}

public class Main {

    public Main() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = Integer.valueOf(in.next());
            int flag = Integer.valueOf(in.next());
            Student[] students = new Student[n];
            for (int i = 0; i < n; i++) {
                students[i] = new Student(in.next(), Integer.valueOf(in.next()));
            }
            if (flag == 1) {
                Arrays.sort(students, Student.DECREASE);
            } else {
                Arrays.sort(students, Student.INCREASE);
            }
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public static void main(String[] args) {
        Main solution = new Main();
    }
}