package com.pratice;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonApp implements Serializable,Cloneable{
    private SingletonApp() {
    }

    private static SingletonApp singletonApp;

    private static SingletonApp getInstance() {
        if (singletonApp == null) {
            synchronized (SingletonApp.class) {
                if (singletonApp == null)
                    singletonApp = new SingletonApp();
            }
        }
        return singletonApp;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, CloneNotSupportedException {
        SingletonApp singletonApp1 = SingletonApp.getInstance();
        SingletonApp singletonApp2 = SingletonApp.getInstance();
        System.out.println("1:: " + singletonApp1);
        System.out.println("2:: " + singletonApp2);

//        Class<?> singletonClass = Class.forName("pratice.SingletonApp");
//        Constructor<?> constructor = singletonClass.getDeclaredConstructor();
//        constructor.setAccessible(true);
//
//        SingletonApp reflectionInstance = (SingletonApp) constructor.newInstance();
//        System.out.println("reflectionInstance:: " +reflectionInstance);
//
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C://Serial.ser"));
//        objectOutputStream.writeObject(singletonApp1);
//        objectOutputStream.close();
//
//        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C://Serial.ser"));
//        SingletonApp singletonApp3 = (SingletonApp) objectInputStream.readObject();

        SingletonApp cloneInstance = (SingletonApp) singletonApp1.clone();
        System.out.println("cloneInstance:: " +cloneInstance);
    }
}
