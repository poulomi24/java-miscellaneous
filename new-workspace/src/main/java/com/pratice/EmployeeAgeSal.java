package com.pratice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class EmployeeAgeSal {
    private int id;
    private int age;
    private double salary;
    private String name;

    public EmployeeAgeSal(int id, int age, double salary, String name) {
        this.id = id;
        this.age = age;
        this.salary = salary;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EmployeeAgeSal{" +
                "id=" + id +
                ", age=" + age +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        EmployeeAgeSal e1 = new EmployeeAgeSal(1, 20, 50000, "Rick");
        EmployeeAgeSal e2 = new EmployeeAgeSal(1, 28, 100000, "Jhick");
        EmployeeAgeSal e3 = new EmployeeAgeSal(1, 27, 150000, "Chick");
        EmployeeAgeSal e4 = new EmployeeAgeSal(1, 23, 60000, "Mick");

        List<EmployeeAgeSal> myList = Arrays.asList(e1,e2,e3,e4);

        Map<Object, Long> newList = myList.stream().filter(x -> x.getAge()>25).collect(Collectors.groupingBy(y -> (y.getSalary()+(0.10* y.getSalary())),Collectors.counting()));
        System.out.println("newList:: " +newList);

    }
}
