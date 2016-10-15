package net.therap.domain.oneToManyUni;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author ashrafhasan
 * @since 10/20/16
 */
@Entity
@Table(name = "table_employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "employee_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "employee_generator", sequenceName = "employee_sequence")
    private long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "employee_id", nullable = false)
    private List<Phone> phoneList;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
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

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneList=" + phoneList +
                '}';
    }
}
