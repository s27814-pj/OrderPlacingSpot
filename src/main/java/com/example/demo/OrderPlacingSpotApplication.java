package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;


@SpringBootApplication
public class OrderPlacingSpotApplication {

	private final OrderService orderService;
	private final OrderStorage orderStorage;

	public OrderPlacingSpotApplication(OrderService orderService, OrderStorage orderStorage){
		this.orderService=orderService;
		this.orderStorage=orderStorage;
		execProcess();
	}



	public static void main(String[] args) {
		SpringApplication.run(OrderPlacingSpotApplication.class, args);}

	public void execProcess(){
		Component comp1 = new Component("pomidor",1);
		List<Component> compList = new ArrayList<Component>();
		compList.add(comp1);
		Order order1 = new Order(compList,1,"ulica 24");
		Order order2 = new Order(compList,10,"ulhhica 24");
		System.out.println(order1.getIdOrder());
		orderService.addOrder(order1);
		order2 = orderService.cancelOrder(0);
		System.out.println(order2.getOrderStatus());
		order2 = orderService.confirmOrder(0);
		System.out.println(order2.getOrderStatus());
		System.out.println(orderService.findOrderById(0).getOrderStatus());
		order2 = orderService.pleaseFindOrderById(0).orElseThrow(() -> new NoSuchElementException("brak elementu"));
		order2 = orderService.pleaseFindOrderById(0).orElseThrow(NoSuchElementException::new);
		System.out.println(order2.getOrderStatus());
		Map<Component, Integer> tmpMap = new LinkedHashMap<>();
		tmpMap.put(comp1, 5);
		order2.doSomeMapThing(tmpMap);
		for (Map.Entry<Component, Integer> entry : order2.getTmpMap().entrySet()){
			System.out.println(entry.getKey().getName() + ":" + entry.getValue());
		}


	}



}
