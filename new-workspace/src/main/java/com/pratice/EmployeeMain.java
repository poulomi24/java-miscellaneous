package com.pratice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeMain {
    public static void main(String[] args) {
        List<String> citiesWorkedIn1 = new ArrayList<>();
        citiesWorkedIn1.add("Pune");
        citiesWorkedIn1.add("Bangalore");
        citiesWorkedIn1.add("Kolkata");
        citiesWorkedIn1.add("Noida");

        EmployeeCity e1 = new EmployeeCity(1, "Poulomi", citiesWorkedIn1);

        List<String> citiesWorkedIn2 = new ArrayList<>();
        citiesWorkedIn2.add("Gurgaon");
        citiesWorkedIn2.add("Chennai");
        citiesWorkedIn2.add("Kolkata");

        EmployeeCity e2 = new EmployeeCity(2, "Roni", citiesWorkedIn2);

        List<String> citiesWorkedIn3 = new ArrayList<>();
        citiesWorkedIn3.add("Chennai");
        citiesWorkedIn3.add("Bangalore");

        EmployeeCity e3 = new EmployeeCity(3, "Rimi", citiesWorkedIn3);

        List<EmployeeCity> employeeCityList = new ArrayList<>();
        employeeCityList.add(e1);
        employeeCityList.add(e2);
        employeeCityList.add(e3);

        System.out.println(employeeCityList);

        List<Integer> ids = new ArrayList<>();
//        for(EmployeeCity employeeCity : employeeCityList)
//        {
//            ids.add(employeeCity.getId());
//        }
//        System.out.println(ids);

       ids = employeeCityList.stream().map(x -> x.getId()).collect(Collectors.toList());
        System.out.println(ids);

        Set<String> citiesWorkedIn = employeeCityList.stream().flatMap(x -> x.getCitiesWorkedIn().stream()).collect(Collectors.toSet());
        System.out.println(citiesWorkedIn);

        EmployeeCity sal1 = new EmployeeCity(1,30000);
        EmployeeCity sal2 = new EmployeeCity(2,18000);
        EmployeeCity sal3 = new EmployeeCity(3,20000);
        EmployeeCity sal4 = new EmployeeCity(4,50004);
        EmployeeCity sal5 = new EmployeeCity(5,50008);

        List<EmployeeCity> empSalList = new ArrayList<>();
        empSalList.add(sal1);
        empSalList.add(sal2);
        empSalList.add(sal3);
        empSalList.add(sal4);
        empSalList.add(sal5);

        List<EmployeeCity> empSortedList = empSalList.stream().sorted((o1,o2) -> (int) (o2.getSalary())-o1.getSalary()).skip(3).collect(Collectors.toList());
        System.out.println("sorted list:: ");
        System.out.println(empSortedList);

        int max = empSalList.stream().collect(Collectors.maxBy(Comparator.comparing(x -> x.getSalary()))).get().getSalary();
        System.out.println("max sal:: "+max);

        double max2 =  empSalList.stream().map(x -> x.getSalary()).mapToDouble(Integer::doubleValue).summaryStatistics().getAverage();
        System.out.println("max 2:: " +max2);

      List<EmployeeCity> employeeCityList1 =  empSalList.stream().sorted((x1,x2) -> x1.getSalary()-x2.getSalary()).collect(Collectors.toList());
        System.out.println("empCityList1:: " +employeeCityList1);

    }
}
