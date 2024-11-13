package com.example.factoriaf5.practice;

public class BWIController {

    public static void calculatorBWI() {

        BWIView userIO = new BWIView();
        double userWeight = userIO.askWeight();
        double userHeight = userIO.askheight();

        Person user = new Person(userWeight, userHeight);
        BWIModel model = new BWIModel(user);

        double bwi = model.calculateBWI();
        String classification = model.giveResultBWString(bwi);

        userIO.showResult(bwi, classification);

    }


    

}
