package com.pandy.test.jsonParseObj;

import java.io.Serializable;
import java.util.List;

/**
 * @author Pandy
 * @date 21/2/2022
 */
public class Employees implements Serializable {
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
