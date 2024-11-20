package com.example.factoriaf5.practice;

public class BWIModel {
    // Calculate BWI
    private final Person person;

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

    public String giveResultBWIString(double bwi) {
        if (bwi > 0 && bwi < 16.0) {
            return "Severe thinness";
        } else if (bwi >= 16.0 && bwi < 17.0) {
            return "Moderate thinness";
        } else if (bwi >= 17.0 && bwi < 18.5) {
            return "Mild thinness";
        } else if (bwi >= 18.5 && bwi < 25.0) {
            return "Normal weight";
        } else if (bwi >= 25.0 && bwi < 30.0) {
            return "Overweight";
        } else if (bwi >= 30.0 && bwi < 35.0) {
            return "Mild obesity";
        } else if (bwi >= 35.0 && bwi < 40.0) {
            return "Moderate obesity";
        } else if (bwi >= 40.0) {
            return "Morbid obesity";
        }
        return "Unable to classify this BWI";
    }
}