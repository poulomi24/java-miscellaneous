package com.pratice;

import java.util.List;

public class EmployeeCity {
    private int id;
    private String name;
    private List<String> citiesWorkedIn;
    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public EmployeeCity(int id, int salary) {
        this.id = id;
        this.salary = salary;
    }

    public EmployeeCity(int id, String name, List<String> citiesWorkedIn) {
        this.id = id;
        this.name = name;
        this.citiesWorkedIn = citiesWorkedIn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EmployeeCity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", citiesWorkedIn=" + citiesWorkedIn +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCitiesWorkedIn() {
        return citiesWorkedIn;
    }

    public void setCitiesWorkedIn(List<String> citiesWorkedIn) {
        this.citiesWorkedIn = citiesWorkedIn;
    }

}
