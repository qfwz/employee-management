package com.employee.model;

public class EmployeeModel {
    private int id;
    private String name;
    private String division;
    private double salary;

    public EmployeeModel(String name, String division, double salary) {
//        this.id = id;
        this.name = name;
        this.division = division;
        this.salary = salary;
    }

    public EmployeeModel(int id, String name, String division, double salary) {
        this.id = id;
        this.name = name;
        this.division = division;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDivision() {
        return division;
    }

    public void setRole(String division) {
        this.division = division;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
