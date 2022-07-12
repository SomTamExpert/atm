package ch.bbw.km.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Client {

    @NotEmpty
    @Size(min = 2, max = 25)
    private String firstname;
    @NotEmpty
    @Size(min = 2, max = 25)
    private String lastname;
    @NotEmpty
    private String streetNr;
    @Pattern(regexp = "[0-9]{4}", message = "The zip code must be exactly 4 digits long")
    private String zipCode;
    @NotEmpty
    private String location;
    @NotEmpty
    private String country;
    @Pattern(regexp = "^(0041|041|\\+41|\\+\\+41|41)?(0|\\(0\\))?([1-9]\\d{1})(\\d{3})(\\d{2})(\\d{2})$", message = "Please enter a valid swiss mobile phone number")
    private String phoneNumber;
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Please enter a valid email address")
    private String email;
    private Account account;
    private Card card;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreetNr() {
        return streetNr;
    }

    public void setStreetNr(String streetNr) {
        this.streetNr = streetNr;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", streetNr='" + streetNr + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", location='" + location + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", account=" + account +
                ", card=" + card +
                '}';
    }
}
