package com.example.factoriaf5.practice;

import java.util.Scanner;


public class BWIView {

    private final Scanner scanner = new Scanner(System.in);

    public BWIView() {
    }

    //ask weight
    public double askWeight() {

        System.out.print("Enter your weight in kilograms: ");
        return scanner.nextDouble();
    }

    //ask height
    public double askheight() {
        System.out.print("Enter your height in meters: ");
        return scanner.nextDouble();
        }

    public void showResult(double bwi, String classification) {
        
        // show bwi result
        System.out.printf("BWI is: %.2f\n\n", bwi );

        // show
        System.out.println("Classification: " + classification);

    }    

    public String askName() {
        System.out.print("Could input your name: ");
        return scanner.next();
    }

    public boolean askToContinue() {
        return askQuestionYN("Do you want to continue?");
    }

    public boolean askViewAllResults() {
        return askQuestionYN("Do you want to view all results?");
    }

    public boolean askQuestionYN(String question) {
        while (true) {
            System.out.print("\n" + question + " Press Y/N : ");
            String response = scanner.next();
            if (response.isEmpty() || response.equalsIgnoreCase("y")) {
                return true;
            } else if (response.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.print("For Continue press \"Y\" , for Exit press \"N\": ");
            }
        }
    }
}
