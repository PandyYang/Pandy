package com.pandy.test.employee;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import kotlin.collections.ArrayDeque;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @author Pandy
 * @date 21/2/2022
 */
public class EmployeeTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee employee3 = new Employee();
        Employee employee4 = new Employee();
        employee1.setName("Max");
        employee2.setName("Sepp");
        employee3.setName("Nina");
        employee4.setName("Mike");
        employee1.setAge(17);
        employee2.setAge(18);
        employee3.setAge(15);
        employee4.setAge(51);
        Employees employees = new Employees();
        List<Employee> list = new ArrayList<Employee>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        employees.setEmployees(list);
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File("/Users/pandy/IdeaProjects/Pandy/src/main/java/com/pandy/test/employee/employee.txt")));
        oo.writeObject(employees.toString());

        oo.close();

        String s = JSON.toJSONString(employees);
        System.out.println("s = " + s);

//        ObjectInputStream ois =
//                new ObjectInputStream(new FileInputStream(new File("/Users/pandy/IdeaProjects/Pandy/src/main/java/com/pandy/test/employee/employee.txt")));
//        Employees employees = (Employees) ois.readObject();
//        System.out.println("成功");

        ObjectMapper objectMapper = new ObjectMapper();

//        objectMapper.writeValue(new File("/Users/pandy/IdeaProjects/Pandy/src/main/java/com/pandy/test/employee/employee.txt"),
//                employees);                             377010

        String sss = "{\"employees\":[{\"name\":\"Max\",\"age\":17},{\"name\":\"Sepp\",\"age\":18},{\"name\":\"Nina\",\"age\":15},{\"name\":\"Mike\",\"age\":51}]}";
        Employees employeesList = objectMapper.readValue(sss, Employees.class);

        List<Employee> employees1 = employeesList.getEmployees().stream().filter(res -> res.getAge() > 18).collect(Collectors.toList());
        System.out.println(employees1);

        List<Employee> employees2 = employeesList.getEmployees().stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
        System.out.println("employees2 = " + employees2);

        System.out.println(employeesList.getEmployees().stream().map(res -> {
            return res.getName().toUpperCase();
        }).collect(Collectors.joining()));

        List<Employee> employees4 = employeesList.getEmployees().stream().sorted((o1, o2) -> o2.getName().compareTo(o1.getName())).collect(Collectors.toList());
        System.out.println("employees2 = " + employees2);
    }

}
