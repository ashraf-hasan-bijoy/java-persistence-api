package net.therap.domain.embeddedEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
@Entity
@Table(name = "table_person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "person_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "person_generator", sequenceName = "person_sequence", allocationSize = 1)
    private long id;

    private String name;

    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @ElementCollection
    @CollectionTable(name = "person_phone_list", joinColumns = {
            @JoinColumn(name = "person_id")
    })
    @OrderColumn(name = "idx")
    private List<Phone> phoneList;

    @ElementCollection
    @CollectionTable(name = "person_nick_names", joinColumns = {
            @JoinColumn(name = "person_id")
    })
    @Column(name = "nick_name")
    private List<String> nickNames;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "street", column = @Column(name = "person_street")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "person_zip_code"))
    })
    private Address address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getNickNames() {
        return nickNames;
    }

    public void setNickNames(List<String> nickNames) {
        this.nickNames = nickNames;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phoneList=" + phoneList +
                ", nickNames=" + nickNames +
                ", address=" + address +
                '}';
    }
}
