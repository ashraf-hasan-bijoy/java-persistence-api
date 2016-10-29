package net.therap;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
public class Employee {

    @Id
    @GeneratedValue(generator = "employeeSeq")
    @SequenceGenerator(name = "employeeSeq", sequenceName = "employee_seq")
    private long id;

    private String name;

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
}
