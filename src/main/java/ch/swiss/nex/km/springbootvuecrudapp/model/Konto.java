package ch.swiss.nex.km.springbootvuecrudapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Konto")
public class Konto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Enumerated(EnumType.STRING)
    private Typ typ;
    @Column(name = "iban")
    private String iban;
    @Column(name = "nummer")
    private int nummer;
    @Column(name = "saldo")
    private double saldo;
    @OneToMany(mappedBy = "gutschriftskonto", cascade = CascadeType.ALL)
    private List<Transaktion> transaktionen = new ArrayList<>();

    public void saldoSetzen(){}
    public void saldoAnzeigen(){}
    public void transaktionenAnzeigen(){}

    public Konto() {
    }

    public Konto(String iban, int nummer, double saldo, List<Transaktion> transaktionen) {
        this.iban = iban;
        this.nummer = nummer;
        this.saldo = saldo;
        this.transaktionen = transaktionen;
    }

    public long getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
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
                "id=" + id +
                ", iban='" + iban + '\'' +
                ", nummer=" + nummer +
                ", saldo=" + saldo +
                ", transaktionen=" + transaktionen +
                '}';
    }
}
