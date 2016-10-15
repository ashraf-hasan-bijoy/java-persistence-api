package net.therap.domain.oneToManyBi;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ashrafhasan
 * @since 10/23/16
 */
@Entity
@Table(name = "table_project")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "project_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "project_generator", sequenceName = "project_sequence")
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public Project(String name, Manager manager) {
        this.name = name;
        this.manager = manager;
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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
