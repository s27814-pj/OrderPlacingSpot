package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderStorage {

    private List<Order> orderList=new ArrayList<>();

    public OrderStorage(){
        this.orderList=new ArrayList<>();
    }
    public void addOrder(Order order){
        orderList.add(order);
    }

    public List<Order> getOrderList() {
        return orderList;
    }
    public void purgeList(){
        orderList.clear();
    }
}
