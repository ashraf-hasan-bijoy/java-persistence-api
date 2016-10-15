package net.therap.domain.accessType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
@Entity
@Table(name = "table_mixed_access_entity")
@Access(AccessType.FIELD)
public class MixedAccessEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "mixed_access_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "mixed_access_generator", sequenceName = "mixed_access_sequence", allocationSize = 1)
    private long id;

    transient private String firstName;

    @Column(name = "l_name")
    private String lastName;

    public MixedAccessEntity() {
    }

    public MixedAccessEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Access(value = AccessType.PROPERTY)
    @Column(name = "f_name_with_prefix")
    public String getFirstNameWithPrefix() {
        return "Mr. " + getFirstName();
    }

    public void setFirstNameWithPrefix(String firstNameWithPrefix) {
        this.setFirstName(firstNameWithPrefix.substring(firstNameWithPrefix.indexOf("Mr. ") + 4));
    }

    @Override
    public String toString() {
        return "MixedAccessEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
