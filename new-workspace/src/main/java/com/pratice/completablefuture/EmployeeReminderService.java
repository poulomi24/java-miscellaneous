package com.pratice.completablefuture;

import com.pratice.completablefuture.database.EmployeeDatabase;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class EmployeeReminderService {
    /**
     * we need to operation for getting all the employees from the db for checking who are pending for the training completion
     * then we need to filter the new joinees
     * check whose learning is pending out of them
     * get the email id for those employees
     * and lastly send a reminder to them
     * Here we are using thenApply as we want to send the output of one completableFuture data to another one.
     * thenApply accepts a function, supplyAsync accepts a supplier. For reminder, we don't need to return anything, hence we are using thenAccept
     */
    public CompletableFuture<Void> sendReminderToEmployee() {
        Executor executor = Executors.newFixedThreadPool(5);
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("fetchEmployees : " + Thread.currentThread().getName());
            return EmployeeDatabase.fetchEmployee();
        },executor).thenApplyAsync((employees -> {
            System.out.println("filter new joiner employees : " + Thread.currentThread().getName());
            return employees.stream()
                    .filter(employee -> "TRUE".equals(employee.getNewJoiner()))
                    .collect(Collectors.toList());
        }),executor).thenApplyAsync(employees -> {
            System.out.println("filter with learning pending : " + Thread.currentThread().getName());
            return employees.stream()
                    .filter(employee -> "TRUE".equals(employee.getLearningPending()))
                    .collect(Collectors.toList());
        },executor).thenApplyAsync((employees -> {
            System.out.println("get mails : " + Thread.currentThread().getName());
            return employees.stream().map(Employee::getEmail).collect(Collectors.toList());
        }),executor).thenAcceptAsync((emails) -> {
            System.out.println("send email notification : " + Thread.currentThread().getName());
            emails.forEach(EmployeeReminderService::sendEmail);
        },executor);
        return voidCompletableFuture;
    }
    
    public static void sendEmail(String email)
    {
        System.out.println("sending training reminder email to : " +email);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        EmployeeReminderService service = new EmployeeReminderService();
        service.sendReminderToEmployee().get();
    }
}
