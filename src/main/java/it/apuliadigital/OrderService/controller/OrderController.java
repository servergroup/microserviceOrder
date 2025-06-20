package it.apuliadigital.OrderService.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.apuliadigital.OrderService.Service.OrderServiceImpl;
import it.apuliadigital.OrderService.model.Order;
import it.apuliadigital.OrderService.model.OrderedItem;
import jakarta.persistence.EntityNotFoundException;

@RequestMapping
@RestController
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping("/addOrders")
    public boolean createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int id) {
        try {
            orderService.deleteOrder(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PutMapping("/quantity")
    public ResponseEntity<Void> updateItemQuantity(
        @PathVariable Integer orderId,
        @PathVariable Integer itemId,
        @RequestBody OrderedItem orderedItem) {
    orderedItem.setItemId(itemId);

    boolean updated = orderService.updateQuantity(orderId, orderedItem);
    if (updated) {
        return ResponseEntity.ok().build();
    } else {
        return ResponseEntity.notFound().build();
    }
    }
}
