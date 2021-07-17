package com.pandy.base.java;

import java.util.ArrayList;

/**
 * @author Pandy
 * @date 2021/3/9 9:44
 */
public class People {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "123";
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        ArrayList<People> arrayList = new ArrayList<>();
        People people1 = new People("张三", 10);
        People people2 = new People("李四", 11);
        People people3 = new People("王五", 12);
        arrayList.add(people1);
        arrayList.add(people2);
        arrayList.add(people3);
        for (People people : arrayList) {
            System.out.println(people.name + people.age);
        }
    }
}
