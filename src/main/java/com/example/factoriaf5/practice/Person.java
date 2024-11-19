package com.example.factoriaf5.practice;

public class Person {
    //Atributes

    private String name;
    private double weight;
    private double height;


    //Create constructor
    public Person(String name, double weight, double height) {
        
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    

}
