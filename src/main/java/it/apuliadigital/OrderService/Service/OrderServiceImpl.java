package it.apuliadigital.OrderService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.apuliadigital.OrderService.model.Order;
import it.apuliadigital.OrderService.model.OrderedItem;
import it.apuliadigital.OrderService.repository.OrderRepository;

@Service
public class OrderServiceImpl implements IOrder 
{

    @Autowired
    private OrderRepository repository;

    @Override
    public Order saveOrder(Order order)
    {
        Order savedOrder = repository.save(order);
        return savedOrder;
    }

    @Override
    public boolean deleteOrder(Integer id) 
    {
        if (id.equals(null)) 
        {
            return false;
        }
        
        Order order = repository.findById(id).orElse(null);
        if(!order.isDelivered())
        {
        	repository.deleteById(id);
        }
        
        return !repository.existsById(id);
    }

    @Override
    public boolean updateQuantity(Integer id, OrderedItem orderedItem) 
    {
        Order order = repository.findById(id).orElse(null);
        if (order == null || orderedItem == null) 
        {
            return false;
        }

        for (OrderedItem item : order.getOrderedItems()) 
        {
            if (item.getItemId() == orderedItem.getItemId()) 
            {
                item.setAmount(orderedItem.getAmount());
                repository.save(order);
                return true;
            }
        }

        return false;
    }
    
      @Override
      public List<Order> getOrders()  
      {
        if (repository == null) 
        {  
           throw new IllegalStateException("OrderRepository is not initialized");
        }
        return (List<Order>) repository.findAll();
      }
     

	@Override
	public List<OrderedItem> getOrderDetail(int id) 
	{
		return  repository.findById(id).get().getOrderedItems();
	}
}
