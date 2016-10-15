package net.therap.domain.embeddedEntity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
@Embeddable
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;

    private int area;

    private int extension;

    public Phone() {
    }

    public Phone(int area, int extension) {
        this.area = area;
        this.extension = extension;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "area=" + area +
                ", extension=" + extension +
                '}';
    }
}
