package net.therap.domain.oneToManyBi;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author ashrafhasan
 * @since 10/23/16
 */
@Entity
@Table(name = "table_manager")
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "manager_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "manager_generator", sequenceName = "manager_sequence")
    private long id;

    private String name;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<Project> projectList;

    public Manager() {
    }

    public Manager(String name) {
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

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", projectList=" + projectList +
                '}';
    }
}
