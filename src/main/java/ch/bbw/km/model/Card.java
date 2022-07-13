package ch.bbw.km.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Class Card is used to store the card data of a client.
 * @author marco karpf
 * @version 12.07.2022
 */
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Card {

    private String pin;
    private String number;
    private String typ;
    private Date validUntil;
    private int cvc;

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    @Override
    public String toString() {
        return "Card{" +
                "pin='" + pin + '\'' +
                ", number='" + number + '\'' +
                ", typ='" + typ + '\'' +
                ", validUntil=" + validUntil +
                ", cvc=" + cvc +
                '}';
    }
}
