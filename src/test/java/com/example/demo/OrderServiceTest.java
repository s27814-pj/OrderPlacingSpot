package com.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class OrderServiceTest {

    private OrderStorage orderStorage;
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderStorage = new OrderStorage();
        orderService = new OrderService(orderStorage);
    }

    @AfterEach
    void tearDown() {
        orderStorage.purgeList();
    }

    @Test
    void shouldFindOrder(){
        List<Component> componentList = new ArrayList<>();
        Component comp1 = new Component("pomidor",2);
        componentList.add(comp1);
        Order order = new Order(componentList,5,"park");

        orderService.addOrder(order);

        Order order1 = orderService.findOrderById(0);

        assertThat(order).isEqualTo(order1);
    }

    @Test
    void shouldNotFindOrder() {

        assertThrows(NoSuchElementException.class, () -> orderService.findOrderById(1));
    }
}