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
        if (bwi < 16.0) {
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
        return "Unable to classify this BMI";
    }

    // public String giveResultBWString(double bwi) {
    //     double imc = bwi;
    //     if (imc < 16.0) {
    //         return "Delgadez severa";
    //     } else if (imc >= 16.0 && imc < 17.0) {
    //         return "Delgadez moderada";
    //     } else if (imc >= 17.0 && imc < 18.5) {
    //         return "Delgadez leve";
    //     } else if (imc >= 18.5 && imc < 25.0) {
    //         return "Peso normal";
    //     } else if (imc >= 25.0 && imc < 30.0) {
    //         return "Sobrepeso";
    //     } else if (imc >= 30.0 && imc < 35.0) {
    //         return "Obesidad leve";
    //     } else if (imc >= 35.0 && imc < 40.0) {
    //         return "Obesidad moderada";
    //     } else if (imc >= 40.0) {
    //         return "Obesidad mórbida";
    //     }
    //     return "No se puede clasificar este IMC";
    // }
    
}