package com.example.factoriaf5.practice;

import java.util.Scanner;

public final class MainController {


    public MainController() {

        Scanner scanner = new Scanner(System.in);

        BWIView userIO = new BWIView(scanner);
        userIO.msgWelcome();
                
        boolean isContinue = true;

        while (isContinue) {

            String name = userIO.askName();
            double userWeight = userIO.askWeight();
            double userHeight = userIO.askHeight();

            Person user = new Person(name, userWeight, userHeight);

            BWIModel model = new BWIModel(user);

            double bwi = model.calculateBWI();
            String classification = model.giveResultBWIString(bwi);

            userIO.showResult(bwi, classification);
            BWIRepo.saveResult(user, bwi, classification);

            isContinue = userIO.askToContinue();
        }
        if (userIO.askViewAllResults()) {BWIRepo.getAllResults();}
    }
}


