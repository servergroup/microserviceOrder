package it.apuliadigital.OrderService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OrderedItem 
{
    @Id
    private int itemId;
    private int orderId;
    private int amount;
    private double price;

    public OrderedItem() 
    {}

    public OrderedItem(int itemId, int orderId, int amount, double price) 
    {
        this.itemId = itemId;
        this.orderId = orderId;
        this.amount = amount;
        this.price = price;
    }

    public int getItemId() 
    {
        return itemId;
    }

    public void setItemId(int itemId) 
    {
        this.itemId = itemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) 
    {
        this.orderId = orderId;
    }

    public int getAmount() 
    {
        return amount;
    }

    public void setAmount(int amount) 
    {
        this.amount = amount;
    }

    public double getPrice() 
    {
        return price;
    }

    public void setPrice(double price) 
    {
        this.price = price;
    }

    @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + itemId;
        result = prime * result + orderId;
        result = prime * result + amount;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderedItem other = (OrderedItem) obj; // Modificato per coerenza (da OrderBook a OrderedItem)
        if (itemId != other.itemId)
            return false;
        if (orderId != other.orderId)
            return false;
        if (amount != other.amount)
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        return true;
    }

    @Override
    public String toString() 
    {
        return "OrderedItem [itemId=" + itemId + ", orderId=" + orderId + ", amount=" + amount + ", price=" + price
                + "]";
    }
}
