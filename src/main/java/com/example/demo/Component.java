package com.example.demo;

public class Component {

    private String name;
    private int amount;

    public Component(String name, int amount){
        this.name=name;
        this.amount=amount;
    }
    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}
