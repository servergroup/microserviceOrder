package it.apuliadigital.OrderService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.apuliadigital.OrderService.Service.OrderServiceImpl;
import it.apuliadigital.OrderService.model.OrderedItem;

import org.springframework.beans.factory.annotation.Autowired;
@RequestMapping
@RestController
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

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
