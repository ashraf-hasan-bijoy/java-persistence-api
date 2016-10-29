package net.therap.domain.manyToManyUni;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
@Entity
@Table(name = "table_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "order_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "order_generator", sequenceName = "order_sequence", allocationSize = 1)
    private long id;

    private int orderNumber;

    private Date orderDate;

    public Order() {
    }

    public Order(int orderNumber, Date orderDate) {
        this.orderDate = orderDate;
        this.orderNumber = orderNumber;
    }

    @ManyToMany
    @JoinTable(name = "table_order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @OrderColumn(name = "idx")
    private List<Product> productList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", orderDate=" + orderDate +
                ", productList=" + productList +
                '}';
    }
}
