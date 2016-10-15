package net.therap.domain.oneToManyUni;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ashrafhasan
 * @since 10/19/16
 */
@Entity
@Table(name = "table_phone")
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "phone_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "phone_generator", sequenceName = "phone_sequence")
    private long id;

    private String area;

    private String extension;

    public Phone() {
    }

    public Phone(String area, String extension) {
        this.area = area;
        this.extension = extension;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", extension='" + extension + '\'' +
                '}';
    }
}
