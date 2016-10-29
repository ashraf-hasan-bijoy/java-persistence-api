package net.therap.domain.oneToOneBi;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ashrafhasan
 * @since 11/1/16
 */
@Entity
@Table(name = "table_country")
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "country_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "country_generator", sequenceName = "country_sequence", allocationSize = 1)
    private long id;

    private String name;

    @OneToOne(mappedBy = "country", orphanRemoval = true, cascade = CascadeType.ALL)
    private PrimeMinister primeMinister;

    public Country() {
    }

    public Country(String name) {
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

    public PrimeMinister getPrimeMinister() {
        return primeMinister;
    }

    public void setPrimeMinister(PrimeMinister primeMinister) {
        this.primeMinister = primeMinister;
    }
}
