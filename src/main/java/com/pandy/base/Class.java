package com.pandy.base;

import java.util.ArrayList;

public class Class {
    private String className;
    private ArrayList<Student> students;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Class(String className, ArrayList<Student> students) {
        this.className = className;
        this.students = students;
    }
}
