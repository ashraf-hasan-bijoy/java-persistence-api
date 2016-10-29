package net.therap;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
public class Product {

    @Id
    @GeneratedValue(generator = "productSeq")
    @SequenceGenerator(name = "productSeq", sequenceName = "product_seq")
    private long id;

    private String name;

    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
