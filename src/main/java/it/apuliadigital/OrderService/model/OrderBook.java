package it.apuliadigital.OrderService.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class OrderBook {
    @Id

    private String isbn;
    private String OrderId;
    private int amount;
    private double price;

    public OrderBook() {
    }

    public OrderBook(String isbn, String orderId, int amount, double price) {
        this.isbn = isbn;
        OrderId = orderId;
        this.amount = amount;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        result = prime * result + ((OrderId == null) ? 0 : OrderId.hashCode());
        result = prime * result + amount;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderBook other = (OrderBook) obj;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        if (OrderId == null) {
            if (other.OrderId != null)
                return false;
        } else if (!OrderId.equals(other.OrderId))
            return false;
        if (amount != other.amount)
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OrderBook [isbn=" + isbn + ", OrderId=" + OrderId + ", amount=" + amount + ", price=" + price + "]";
    }

}
