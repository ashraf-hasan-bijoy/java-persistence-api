package net.therap.domain.oneToOneUni;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
@Entity
@Table(name = "table_employee", uniqueConstraints = {@UniqueConstraint(columnNames = "p_id")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "employee_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "employee_generator", sequenceName = "employee_sequence", allocationSize = 1)
    private long id;

    private String name;

    public Employee() {
    }

    public Employee(String name, ParkingSpace parkingSpace) {
        this.name = name;
        this.parkingSpace = parkingSpace;
    }

    @OneToOne
    @JoinColumn(name = "p_id")
    private ParkingSpace parkingSpace;

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

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parkingSpace=" + parkingSpace +
                '}';
    }
}
