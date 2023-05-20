package com.pratice;

import java.util.Objects;

public class Employee1 implements Comparable{
    String name;
    int age;

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

    Employee1(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.age - ((Employee1) o).age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee1 employee1 = (Employee1) o;
        if(name == null)
        {
            if(employee1.name!=null)
                return false;
        }
        else if(!name.equals(employee1.name))
            return false;
        return true;
     //   return age == employee1.age && name.equals(employee1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}