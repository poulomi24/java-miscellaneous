package com.pratice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapIncreaseSalaryDemo {
    final static double INCREMENT_SALARY = 10000;
    public static void main(String[] args) {

        List<TryEmp> employees = Arrays.asList(
                new TryEmp(1, "Gerhard", 90000),
                new TryEmp(2, "Peter", 100000),
                new TryEmp(3, "Andriya", 60000),
                new TryEmp(4, "Ashja", 80000)
        );

        List<TryEmp> newEployees = employees.stream().map(e ->
        {
            e.setSalary(e.getSalary()+INCREMENT_SALARY);
            return e;
        }).collect(Collectors.toList());



        System.out.println(newEployees);
    }
}