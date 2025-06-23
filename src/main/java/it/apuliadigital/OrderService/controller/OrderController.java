package it.apuliadigital.OrderService.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import it.apuliadigital.OrderService.Service.OrderServiceImpl;
import it.apuliadigital.OrderService.model.Order;
import it.apuliadigital.OrderService.model.OrderedItem;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@RequestMapping
@RestController
public class OrderController 
{

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping("/addOrders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order)
    {
        return ResponseEntity.ok(orderService.saveOrder(order));
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int id) 
    {
        try {
            orderService.deleteOrder(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PutMapping("/quantity")
    public ResponseEntity<Void> updateItemQuantity(@PathVariable Integer orderId,@PathVariable Integer itemId,@RequestBody OrderedItem orderedItem) 
    {
    	orderedItem.setItemId(itemId);

    	boolean updated = orderService.updateQuantity(orderId, orderedItem);
    	if (updated) 
    	{
    		return ResponseEntity.ok().build();
    	} else 
    	{
    		return ResponseEntity.notFound().build();
    	}
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    // New GET endpoint to fetch ordered items by order id
    @GetMapping("/{id}/details")
    public ResponseEntity<List<OrderedItem>> getOrderDetail(@PathVariable int id) {
        List<OrderedItem> orderedItems = orderService.getOrderDetail(id);
        if (orderedItems == null || orderedItems.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orderedItems);
    }

}
