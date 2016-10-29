package net.therap.domain.oneToOneBi;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ashrafhasan
 * @since 11/1/16
 */
@Entity
@Table(name = "table_city")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "city_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "city_generator", sequenceName = "city_sequence", allocationSize = 1)
    private long id;

    private String name;

    @OneToOne(mappedBy = "city", cascade = CascadeType.ALL)
    private Mayor mayor;

    public City() {
    }

    public City(String name) {
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

    public Mayor getMayor() {
        return mayor;
    }

    public void setMayor(Mayor mayor) {
        this.mayor = mayor;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mayor=" + mayor.getName() +
                '}';
    }
}
