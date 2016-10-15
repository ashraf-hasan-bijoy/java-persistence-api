package net.therap.domain.tableAnnotation;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
@Entity(name = "CustomerEntity")
@Table(name = "table_customer", uniqueConstraints = @UniqueConstraint(columnNames = {"customerId", "name"}))
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "customer_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "customer_generator", sequenceName = "customer_sequence", allocationSize = 1)
    private long id;

    private String customerId;

    private String name;

    public Customer() {
    }

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
