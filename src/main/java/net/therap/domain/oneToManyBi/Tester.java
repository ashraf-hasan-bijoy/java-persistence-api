package net.therap.domain.oneToManyBi;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author ashrafhasan
 * @since 10/19/16
 */
@Entity
@Table(name = "table_tester")
public class Tester implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "tester_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "tester_generator", sequenceName = "tester_sequence")
    private long id;

    private String name;

    public Tester() {
    }

    public Tester(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL)
    private List<TestPlan> testPlans;

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

    public List<TestPlan> getTestPlans() {
        return testPlans;
    }

    public void setTestPlans(List<TestPlan> testPlans) {
        this.testPlans = testPlans;
    }

    @Override
    public String toString() {
        return "Tester{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", testPlans=" + testPlans +
                '}';
    }
}
