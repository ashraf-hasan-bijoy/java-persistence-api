package net.therap.domain.embeddedEntity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
@Embeddable
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    private String street;

    private String zipCode;

    public Address() {
    }

    public Address(String street, String zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
