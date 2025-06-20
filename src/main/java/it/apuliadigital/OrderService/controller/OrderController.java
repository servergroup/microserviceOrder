package it.apuliadigital.OrderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.apuliadigital.OrderService.Service.IOrder;
import it.apuliadigital.OrderService.model.Order;

@RestController
public class OrderController {
    
    @Autowired
    private IOrder orderService;
    @PostMapping("/addOrders")

    public boolean createOrder(@RequestBody Order order){
       return orderService.saveOrder(order);
    }
    
}
