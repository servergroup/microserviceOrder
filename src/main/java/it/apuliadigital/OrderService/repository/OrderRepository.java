package it.apuliadigital.OrderService.repository;

import org.springframework.data.repository.CrudRepository;

import it.apuliadigital.OrderService.model.Order;

public interface OrderRepository extends CrudRepository<Order,Integer> 
{    
}
