package net.therap.domain.oneToOneBi;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ashrafhasan
 * @since 11/1/16
 */
@Entity
@Table(name = "table_mayor", uniqueConstraints = @UniqueConstraint(columnNames = {"c_id"}))
public class Mayor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "mayor_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "mayor_generator", sequenceName = "mayor_sequence", allocationSize = 1)
    private long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "c_id")
    private City city;

    public Mayor() {
    }

    public Mayor(String name) {
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Mayor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city.getName() +
                '}';
    }
}
