package it.apuliadigital.OrderService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.apuliadigital.OrderService.model.Order;
import it.apuliadigital.OrderService.model.OrderedItem;
import it.apuliadigital.OrderService.repository.OrderRepository;

public class OrderServiceImpl implements IOrder {

    @Autowired
    private OrderRepository repository;

    @Override
    public boolean saveOrder(Order order) {
        repository.save(order);
        return repository.existsById(order.getOrderId());
    }

    @Override
    public boolean deleteOrder(Integer id) {
        if (id.equals(null)) {
            return false;
        }
        repository.deleteById(id);

        return !repository.existsById(id);
    }

    @Override
    public boolean updateQuantiity(Integer id, OrderedItem orderedItem) {
        Order order = repository.findById(id).orElse(null);
        if (order == null || orderedItem == null) {
            return false;
        }

        for (OrderedItem item : order.getOrderedItems()) {
            if (item.getItemId() == orderedItem.getItemId()) {
                item.setQuantity(orderedItem.getQuantity());
                repository.save(order);
                return true;
            }
        }

        return false;
    }
    
      @Override
      public List<Order> getOrders()  {
        if (repository == null) {
            
           throw new IllegalStateException("OrderRepository is not initialized");
        }
    return (List<Order>) repository.findAll();
      }
     
     //* @Override
     /** public Order getOrderDetail(int id) {
     * // TODO Auto-generated method stub
     * throw new
     * UnsupportedOperationException("Unimplemented method 'getOrderDetail'");
     * }
     */
    
   

   

}
