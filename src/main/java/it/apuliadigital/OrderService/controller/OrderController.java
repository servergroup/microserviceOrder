package it.apuliadigital.OrderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.apuliadigital.OrderService.Service.OrderServiceImpl;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/orders")
public class OrderController 
{
	@Autowired
	private OrderServiceImpl orderService;
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable int id) {
	    try {
	        orderService.deleteOrder(id);
	        return ResponseEntity.noContent().build(); // 204 No Content
	    } catch (EntityNotFoundException e) {
	        return ResponseEntity.notFound().build(); // 404 Not Found
	    }
	}
}
