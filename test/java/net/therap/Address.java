package net.therap;

import javax.persistence.Embeddable;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
@Embeddable
public class Address {

    private String street;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
