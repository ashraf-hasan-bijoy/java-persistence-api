package net.therap.domain.manyToOneUni;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
@Entity
@Table(name = "table_university")
public class University implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "university_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "university_generator", sequenceName = "university_sequence")
    private long id;

    private String name;

    public University() {
    }

    public University(String name) {
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

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
