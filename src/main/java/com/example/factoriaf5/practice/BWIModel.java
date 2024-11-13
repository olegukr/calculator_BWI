package com.example.factoriaf5.practice;

public class BWIModel {
    // Calculate BWI
    private Person person;

    public BWIModel(Person person) {
        this.person = person;
    }

    // 2 methods

    public double calculateBWI() {
        double weight = this.person.getWeight();
        double height = this.person.getHeight();
        double bwi = weight / Math.pow(height, 2);
        return bwi;
    }

    public String giveResultBWString(double bwi) {

        if (bwi < 16.0) {return "Severe thinness";}
        else if (bwi <= 17) {return "Moderate thinness";}
        else if (bwi <= 18.5) {return "Mild thinness";}
        else if (bwi <= 25) {return "Normal weight";}
        else if (bwi <= 30) {return "Overweight";}
        else if (bwi <= 35) {return "Mild obesity";}
        else if (bwi < 40) {return "Moderate  obesity";}
        else if (bwi >=40) {return "Morbid obesity";}
        return "we can't classificate this WMI";
    }
}
