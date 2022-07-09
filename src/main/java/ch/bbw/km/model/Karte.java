package ch.bbw.km.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;


@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Karte {

    private String pin;
    private String nummer;
    private String typ;

    private Date gueligkeitsdatum;
    private int cvc;


    public Karte(String pin, String nummer, String typ, Date gueligkeitsdatum, int cvc) {
        this.pin = pin;
        this.nummer = nummer;
        this.typ = typ;
        this.gueligkeitsdatum = gueligkeitsdatum;
        this.cvc = cvc;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Date getGueligkeitsdatum() {
        return gueligkeitsdatum;
    }

    public void setGueligkeitsdatum(Date gueligkeitsdatum) {
        this.gueligkeitsdatum = gueligkeitsdatum;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }


    @Override
    public String toString() {
        return "Karte{" +
                ", pin=" + pin +
                ", nummer=" + nummer +
                ", typ='" + typ + '\'' +
                ", gueligkeitsdatum=" + gueligkeitsdatum +
                ", cvc=" + cvc +
                '}';
    }
}
