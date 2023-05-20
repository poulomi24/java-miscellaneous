package com.pratice.completablefuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RunAsyncDemo {
    public Void saveEmployees(File jsonFile) throws ExecutionException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        CompletableFuture<Void> runAsyncCompletableFuture = CompletableFuture.runAsync(() ->
        {
            try {
                List<Employee> employees = mapper.readValue(jsonFile, new TypeReference<List<Employee>>() {
                });
                //write logic to save list of employees to database
                //in springboot we can directly call repository.saveAll(employees)
                System.out.println("Thread : " + Thread.currentThread().getName());
                System.out.println(employees.size());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

       return runAsyncCompletableFuture.get();
    }

    public Void saveEmployeesWithCustomExecutor(File jsonFile) throws ExecutionException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Executor executor = Executors.newFixedThreadPool(5);
        CompletableFuture<Void> runAsyncCompletableFuture = CompletableFuture.runAsync(() ->
        {
            try {
                List<Employee> employees = mapper.readValue(jsonFile, new TypeReference<List<Employee>>() {
                });
                //write logic to save list of employees to database
                //in springboot we can directly call repository.saveAll(employees)
                System.out.println("Thread : " + Thread.currentThread().getName());
                System.out.println(employees.size());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        },executor);

        return runAsyncCompletableFuture.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RunAsyncDemo runAsyncDemo = new RunAsyncDemo();
        runAsyncDemo.saveEmployees(new File("employees.json"));
        runAsyncDemo.saveEmployeesWithCustomExecutor(new File("employees.json"));
    }
}
