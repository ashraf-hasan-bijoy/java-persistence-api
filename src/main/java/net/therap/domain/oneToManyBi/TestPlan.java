package net.therap.domain.oneToManyBi;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ashrafhasan
 * @since 10/19/16
 */
@Entity
@Table(name = "table_test_plan")
public class TestPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "test_plan_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "test_plan_generator", sequenceName = "test_plan_sequence")
    private long id;

    private String model;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "tester_id")
    private Tester tester;

    public TestPlan() {
    }

    public TestPlan(String model, Tester tester) {
        this.model = model;
        this.tester = tester;
    }

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

    public Tester getTester() {
        return tester;
    }

    public void setTester(Tester tester) {
        this.tester = tester;
    }

    @Override
    public String toString() {
        return "TestPlan{" +
                "id=" + id +
                ", model='" + model + '\'' +
                '}';
    }
}
