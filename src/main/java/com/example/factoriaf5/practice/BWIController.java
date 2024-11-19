package com.example.factoriaf5.practice;

public class BWIController {

    BWIView view = new BWIView();

    public BWIController() {
    }

    public double getWeight() {
        return  view.askWeight();
    }

    public double getHeight() {
        return view.askheight();
    }

    public String getName() {
        return view.askName();
    }

}
