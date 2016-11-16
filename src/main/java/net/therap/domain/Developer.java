package net.therap.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
@Entity
@Table(name = "table_developer")
public class Developer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "developer_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "developer_generator", sequenceName = "developer_sequence")
    private long id;

    private String name;

    public Developer() {
    }

    public Developer(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feature> featureList;

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

    public List<Feature> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<Feature> featureList) {
        this.featureList = featureList;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", featureList=" + featureList +
                '}';
    }
}
