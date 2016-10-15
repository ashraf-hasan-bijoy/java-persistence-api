package net.therap.domain.oneToManyUni;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
@Entity
@Table(name = "table_sim")
public class Sim implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "sim_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sim_generator", sequenceName = "sim_sequence")
    private long id;

    private String operator;

    public Sim() {
    }

    public Sim(String operator) {
        this.operator = operator;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Sim{" +
                "id=" + id +
                ", operator='" + operator + '\'' +
                '}';
    }
}
