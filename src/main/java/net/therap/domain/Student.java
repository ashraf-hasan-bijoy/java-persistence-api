package net.therap.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
@Entity
@Table(name = "table_student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "student_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "student_generator", sequenceName = "student_sequence")
    private long id;

    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "uni_id", nullable = false)
    private University university;

    public Student() {
    }

    public Student(String name, University university) {
        this.name = name;
        this.university = university;
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

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", university=" + university +
                '}';
    }
}
