package com.factory.hospital;

public class ProfessionFactory{
    public Profession getProfession(String typesOfProfession)
    {
        if(typesOfProfession == null){
            return null;
        }
        if(typesOfProfession.equalsIgnoreCase("Doctor"))
            return new Doctor();
        if(typesOfProfession.equalsIgnoreCase("Receptionist"))
            return new Receptionist();
        if(typesOfProfession.equalsIgnoreCase("Housekeeping"))
            return new Housekeeping();
        return null;
    }
}
