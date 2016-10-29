package net.therap;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(generator = "customerSeq")
    @SequenceGenerator(name = "customerSeq", sequenceName = "customer_seq")
    private long id;

    private String name;

    private int age;

    @Embedded
    private Address address;

    @ElementCollection
    @CollectionTable
    private List<Phone> phoneList;

    @OneToMany(mappedBy = "customer")
    private List<Order> orderList;

    public Customer() {
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
