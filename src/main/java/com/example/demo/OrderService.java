package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderService {
    private final OrderStorage orderStorage;

    public OrderService(OrderStorage orderStorage){this.orderStorage=orderStorage;}

    public void addOrder(Order order){

         if (validateList(order.getComponentList())) orderStorage.addOrder(order);
         else throw new RuntimeException("lista komponentow ma niepoprawne dane");

    }

    public Order findOrderById(int id){
        Order order=null;
        for (Order o : orderStorage.getOrderList()){
            if (o.getIdOrder() == id ){
                order =o;
                break;
            }
        }
        if (order ==null){
            throw new NoSuchElementException();
        } else{
            return order;
        }
    }
    public OrderStatus checkStatus(int id){
        Order order = null;
        order = findOrderById(id);
        return order.getOrderStatus();
    }

    public Order cancelOrder(int id){
        if ((findOrderById(id).getOrderStatus()==OrderStatus.W_REALIZACJI)) {
            findOrderById(id).setOrderStatus(OrderStatus.ANULOWANE); //nosuchelement info zwrotne
        }
    return findOrderById(id);
    }
    public Order confirmOrder(int id){
       findOrderById(id).setOrderStatus(OrderStatus.DOSTARCZONE);
        return findOrderById(id);
    }

    private Boolean validateList(List<Component> componentList){
        for (Component c : componentList){
            if (c.getAmount()<=0) return false;
        }
        return true;
    }
}
