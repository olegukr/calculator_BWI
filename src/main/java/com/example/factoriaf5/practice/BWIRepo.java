package com.example.factoriaf5.practice;

import java.util.ArrayList;
import java.util.List;

public class BWIRepo {
    
    private static final List<String> calculationHistory = new ArrayList<>();
    
    public BWIRepo() {
    }
    
    public static void saveResult(Person person, double bwi, String classification) {
            
        String record = "name: " + person.getName() + 
        "; weight: " + person.getWeight() + 
        "; height: " + person.getHeight() +
        "; BWI: " + bwi +
        "; diagnosis: " + classification;
        calculationHistory.add(record);
    }

    public static void getAllResults() {
        if (calculationHistory.isEmpty()) {
            System.out.println("No results to display.");
            return;
        }
        System.out.println("Calculation History:");
        for (String record : calculationHistory) {
            System.out.println(record);
        }
    }
}
