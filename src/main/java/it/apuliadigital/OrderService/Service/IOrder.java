package it.apuliadigital.OrderService.Service;

import it.apuliadigital.OrderService.model.Order;

public interface IOrder {
    public boolean saveOrder(Order order);
    public boolean deleteOrder(Integer id);
        public boolean updateQuantiity(int id,int amount);
        //public List<Order> getOrders();
        //public Order getOrderDetail(int id);

        
}
