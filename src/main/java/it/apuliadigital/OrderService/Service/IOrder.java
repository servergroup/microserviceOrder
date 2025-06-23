package it.apuliadigital.OrderService.Service;

import java.util.List;

import it.apuliadigital.OrderService.model.Order;
import it.apuliadigital.OrderService.model.OrderedItem;

public interface IOrder 
{
    public Order saveOrder(Order order);

    public boolean deleteOrder(Integer id);

    public boolean updateQuantity(Integer id, OrderedItem newItem);
    
    public List<Order> getOrders();
    
    public List<OrderedItem> getOrderDetail(int id);
}
