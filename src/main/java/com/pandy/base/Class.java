package com.pandy.base;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Class {
    private String className;
    private ArrayList<Student> students;
}
