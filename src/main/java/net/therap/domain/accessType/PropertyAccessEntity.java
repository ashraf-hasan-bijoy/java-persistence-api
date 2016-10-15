package net.therap.domain.accessType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
@Entity
@Table(name = "table_property_access_entity")
public class PropertyAccessEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String firstName;

    private String lastName;

    public PropertyAccessEntity() {
    }

    public PropertyAccessEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue(generator = "property_access_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "property_access_generator", sequenceName = "property_access_sequence", allocationSize = 1)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "f_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "l_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "PropertyAccessEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
