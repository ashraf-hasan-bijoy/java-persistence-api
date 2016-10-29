package net.therap;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
public class Order {

    @Id
    @GeneratedValue(generator = "orderSeq")
    @SequenceGenerator(name = "orderSeq", sequenceName = "order_seq")
    private long id;

    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;

    @ManyToMany
    @JoinTable
    private List<Product> products;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
