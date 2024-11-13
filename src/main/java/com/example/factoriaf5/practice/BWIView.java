package com.example.factoriaf5.practice;

import java.util.Scanner;


public class BWIView {

    private Scanner scanner = new Scanner(System.in);
    
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
        System.out.printf("your BWI is: %.2f\n\n", bwi );

        // show
        System.out.println("Your status: " + classification);

    }    
}
