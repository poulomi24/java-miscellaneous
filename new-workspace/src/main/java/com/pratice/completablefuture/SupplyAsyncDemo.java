package com.pratice.completablefuture;

import com.pratice.completablefuture.database.EmployeeDatabase;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SupplyAsyncDemo {
    Executor executor = Executors.newCachedThreadPool();
    public List<Employee> getEmployees() throws ExecutionException, InterruptedException {
        CompletableFuture<List<Employee>> listCompletableFuture = CompletableFuture.supplyAsync(() ->
        {
            System.out.println("Executed by : " +Thread.currentThread().getName());
            return EmployeeDatabase.fetchEmployee();
        },executor);
        return listCompletableFuture.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SupplyAsyncDemo supplyAsyncDemo = new SupplyAsyncDemo();
        List<Employee> employees=supplyAsyncDemo.getEmployees();
        employees.stream().forEach(System.out::println);
    }
}
