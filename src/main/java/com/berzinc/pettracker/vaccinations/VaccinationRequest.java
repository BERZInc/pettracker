package com.berzinc.pettracker.vaccinations;

public class VaccinationRequest {
    private String petName;
    private String date;
    private String vaccName;
    
    public VaccinationRequest(String petName, String date, String vaccName) {
        this.petName = petName;
        this.date = date;
        this.vaccName = vaccName;
    }
    public String getPetName() {
        return petName;
    }
    public void setPetName(String petName) {
        this.petName = petName;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getVaccName() {
        return vaccName;
    }
    public void setVaccName(String vaccName) {
        this.vaccName = vaccName;
    }
}
