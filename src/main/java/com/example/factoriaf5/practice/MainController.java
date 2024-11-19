package com.example.factoriaf5.practice;

public final class MainController {

    public MainController() {

        BWIView userIO = new BWIView();
        BWIController controller = new BWIController();
        
        boolean isContinue = true;

        while (isContinue) {

            String name = userIO.askName();
            double userWeight = userIO.askWeight();
            double userHeight = userIO.askheight();

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


