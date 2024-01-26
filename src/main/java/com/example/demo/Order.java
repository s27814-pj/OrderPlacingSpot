package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Component> componentList=new ArrayList<>();
    private int idClient;
    private String address;
    private int idOrder;
    private static int orderCounter =0;
    private OrderStatus orderStatus;



    public Order(List<Component> componentList, int idClient, String address) {
        this.componentList = componentList;
        this.idClient = idClient;
        this.address = address;
        this.idOrder=orderCounter++;
        this.orderStatus=OrderStatus.NOWE;
    }

    public List<Component> getComponentList() {
        return componentList;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getAddress() {
        return address;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
