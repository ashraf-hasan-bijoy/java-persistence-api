package net.therap.domain.oneToManyUni;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
@Entity
@Table(name = "table_mobile_set")
public class MobileSet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "mobile_set_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "mobile_set_generator", sequenceName = "mobile_set_sequence")
    private long id;

    private String model;

    public MobileSet() {
    }

    public MobileSet(String model) {
        this.model = model;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "table_mobile_sim",
            joinColumns = @JoinColumn(name = "mobile_id"),
            inverseJoinColumns = @JoinColumn(name = "sim_id"))
    @OrderColumn(name = "idx")
    private List<Sim> simList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Sim> getSimList() {
        return simList;
    }

    public void setSimList(List<Sim> simList) {
        this.simList = simList;
    }

    @Override
    public String toString() {
        return "MobileSet{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", simList=" + simList +
                '}';
    }
}
