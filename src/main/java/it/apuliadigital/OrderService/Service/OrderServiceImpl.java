package it.apuliadigital.OrderService.Service;

import org.springframework.beans.factory.annotation.Autowired;

import it.apuliadigital.OrderService.model.Order;
import it.apuliadigital.OrderService.model.OrderBook;
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
        if(id.equals(null)){
            return false;
        }
        repository.deleteById(id);

        return !repository.existsById(id);
    }

    @Override
    public boolean updateQuantiity(Integer id) {
      Order order=new Order();
      OrderBook orderBook=new OrderBook();

      order.setOrderId(id);
      orderBook.setAmount(amount);  

        return false;
    }
/* 
    @Override
    public List<Order> getOrders() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrders'");
    }

    @Override
    public Order getOrderDetail(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrderDetail'");
    }
*/
 //@Override
//    public List<Order> getOrders() {
        // TODO Auto-generated method stub
  //      throw new UnsupportedOperationException("Unimplemented method 'getOrders'");
    //}

//    @Override
  //  public Order getOrderDetail(String id) {
        
    //}

}
