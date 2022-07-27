package com.pandy.test.jsonParseObj;

import java.io.Serializable;

/**
 * @author Pandy
 * @date 21/2/2022
 */
public class Employee implements Serializable {

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
}
