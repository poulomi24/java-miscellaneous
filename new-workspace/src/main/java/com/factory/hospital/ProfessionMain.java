package com.factory.hospital;

public class ProfessionMain {
    public static void main(String[] args) {
        ProfessionFactory professionFactory = new ProfessionFactory();

        Profession doc = professionFactory.getProfession("Doctor");
        doc.printProfession();

        Profession receptionist = professionFactory.getProfession("Receptionist");
        receptionist.printProfession();

        Profession housekeeping = professionFactory.getProfession("Housekeeping");
        housekeeping.printProfession();
    }
}
