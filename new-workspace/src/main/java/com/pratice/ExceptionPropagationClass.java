package com.pratice;

public class ExceptionPropagationClass {

    public static void main(String[] args) {
        System.out.println("In main method");
        ExceptionPropagationClass exceptionPropagationClass = new ExceptionPropagationClass();
        exceptionPropagationClass.a();
    }

    public void a(){
        System.out.println("In a method");
        b();
    }

    public void b(){
        System.out.println("In b method");
        throw new NullPointerException();
    }
}
