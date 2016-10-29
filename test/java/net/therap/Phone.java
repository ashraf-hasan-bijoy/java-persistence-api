package net.therap;

import javax.persistence.Embeddable;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
@Embeddable
public class Phone {

    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
