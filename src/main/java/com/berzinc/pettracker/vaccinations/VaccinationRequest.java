package com.berzinc.pettracker.vaccinations;

import java.sql.Date;

public class VaccinationRequest {
    private String petName;
    private Date date;
    private String name;

    public VaccinationRequest(String petName, Date date, String name) {
        this.petName = petName;
        this.date = date;
        this.name = name;
    }

    public VaccinationRequest() {
        
    }

    public String getPetName() {
        return petName;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}
