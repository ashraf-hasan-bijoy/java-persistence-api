package net.therap.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
@Entity
@Table(name = "table_vice_chancellor", uniqueConstraints = @UniqueConstraint(columnNames = {"u_id"}))
public class ViceChancellor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "vice_chancellor_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "vice_chancellor_generator", sequenceName = "vice_chancellor_sequence", allocationSize = 1)
    private long id;

    private String name;

    public ViceChancellor() {
    }

    public ViceChancellor(String name, University university) {
        this.name = name;
        this.university = university;
    }

    @OneToOne
    @JoinColumn(name = "u_id")
    private University university;

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

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "ViceChancellor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}