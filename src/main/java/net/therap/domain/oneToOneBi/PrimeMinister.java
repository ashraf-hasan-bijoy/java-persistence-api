package net.therap.domain.oneToOneBi;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ashrafhasan
 * @since 11/1/16
 */
@Entity
@Table(name = "table_prime_minister", uniqueConstraints = @UniqueConstraint(columnNames = {"c_id"}))
public class PrimeMinister implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prime_minister_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "prime_minister_generator", sequenceName = "prime_minister_sequence", allocationSize = 1)
    private long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_id", nullable = false, updatable = false)
    private Country country;

    public PrimeMinister() {
    }

    public PrimeMinister(String name) {
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
