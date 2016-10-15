package net.therap.domain.primaryKey;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
@Entity
@Table(name = "table_allocation_size_one")
public class AllocationSizeOne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "alloc_size_one_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "alloc_size_one_generator",
            sequenceName = "alloc_size_one_sequence", initialValue = 1,
            allocationSize = 1)
    private long id;

    private String property;

    public AllocationSizeOne() {
    }

    public AllocationSizeOne(String property) {
        this.property = property;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "AllocationSizeOne{" +
                "id=" + id +
                ", property='" + property + '\'' +
                '}';
    }
}
