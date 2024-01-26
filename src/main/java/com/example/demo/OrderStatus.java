package com.example.demo;

public enum OrderStatus {
    NOWE("Nie ma takiego zamowienia"),
    W_REALIZACJI("Zamowienie zostało stworzone"),
    DOSTARCZONE("Zamowienie jest w trakcie realizacji"),
    ANULOWANE("Zamowienie zostalo dostarczone"),
    NIE_ISTNIEJE("Zamowienie zostalo anulowane");

    private final String description;

    public String getDescription() {
        return description;
    }

    OrderStatus(String description){
        this.description=description;
    }
}
