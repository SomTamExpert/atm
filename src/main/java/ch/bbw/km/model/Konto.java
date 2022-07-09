package ch.bbw.km.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class Konto {

    private String typ;
    private int nummer;
    private double saldo;
    private List<Transaktion> transaktionen = new ArrayList<>();

    public void saldoSetzen() {
    }

    public void saldoAnzeigen() {
    }

    public void transaktionenAnzeigen() {
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Transaktion> getTransaktionen() {
        return transaktionen;
    }

    public void setTransaktionen(List<Transaktion> transaktionen) {
        this.transaktionen = transaktionen;
    }

    @Override
    public String toString() {
        return "Konto{" +
                ", nummer=" + nummer +
                ", saldo=" + saldo +
                ", transaktionen=" + transaktionen +
                '}';
    }
}
