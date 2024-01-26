package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class OrderServiceITTest {

    @MockBean
    private OrderStorage orderStorage;
    @Autowired
    private OrderService orderService;

    @Test
    void shouldFindOrder(){

        List<Component> componentList = new ArrayList<>();
        Component comp1 = new Component("pomidor",2);
        componentList.add(comp1);
        Order order = new Order(componentList,5,"park");
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        when(orderStorage.getOrderList()).thenReturn(orderList);

        Order order1 = orderService.findOrderById(0);

        assertThat(order).isEqualTo(order1);


    }
@Test
    void shouldNotFindOrder(){

        List<Component> componentList = new ArrayList<>();
        Component comp1 = new Component("pomidor",2);
        componentList.add(comp1);
        Order order = new Order(componentList,5,"park");
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        when(orderStorage.getOrderList()).thenReturn(orderList);

        assertThrows(NoSuchElementException.class, ()->orderService.findOrderById(1));




    }

}