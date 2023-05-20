package com.factory.hospital;

public class Doctor implements Profession{
    @Override
    public void printProfession() {
        System.out.println("Doctor treats the patient");
    }
}
