package ch.bbw.km.model;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component

public class Transaction {


    private LocalDateTime zeitpunkt;
    private double betrag;
    private String waehrung;
    private String transtyp;

    public Transaction() {
    }

    public LocalDateTime getZeitpunkt() {
        return zeitpunkt;
    }

    public void setZeitpunkt(LocalDateTime zeitpunkt) {
        this.zeitpunkt = zeitpunkt;
    }

    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    public String getWaehrung() {
        return waehrung;
    }

    public void setWaehrung(String waehrung) {
        this.waehrung = waehrung;
    }

    public String getTranstyp() {
        return transtyp;
    }

    public void setTranstyp(String transtyp) {
        this.transtyp = transtyp;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "zeitpunkt=" + zeitpunkt +
                ", betrag=" + betrag +
                ", waehrung='" + waehrung + '\'' +
                ", transtyp=" + transtyp +
                '}';
    }
}
