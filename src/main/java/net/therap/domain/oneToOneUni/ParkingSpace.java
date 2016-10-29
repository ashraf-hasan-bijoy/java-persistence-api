package net.therap.domain.oneToOneUni;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
@Entity
@Table(name = "table_parking_space")
public class ParkingSpace implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "parking_space_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "parking_space_generator", sequenceName = "parking_space_sequence", allocationSize = 1)
    private long id;

    public ParkingSpace() {
    }

    public ParkingSpace(int position) {
        this.position = position;
    }

    private int position;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "id=" + id +
                ", position=" + position +
                '}';
    }
}
