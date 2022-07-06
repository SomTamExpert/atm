package ch.bbw.km.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
@Table(name = "Karte")
public class Karte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "pin")
    private int pin;
    @Column(name = "nummer")
    private int nummer;
    @Column(name = "typ")
    private String typ;
    @Column(name = "gueligkeitsdatum")
    private LocalDate gueligkeitsdatum;
    @Column(name = "cvc")
    private int cvc;
    @OneToMany(mappedBy = "karte", cascade = CascadeType.ALL)
    private List<Konto> kontos = new ArrayList<>();

    public Karte() {
    }

    public Karte(int pin, int nummer, String typ, LocalDate gueligkeitsdatum, int cvc, List<Konto> kontos) {
        this.pin = pin;
        this.nummer = nummer;
        this.typ = typ;
        this.gueligkeitsdatum = gueligkeitsdatum;
        this.cvc = cvc;
        this.kontos = kontos;
    }

    public void pinSetzen(){}
    public void pinZurueckgeben(){}

    public long getId() {
        return id;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public LocalDate getGueligkeitsdatum() {
        return gueligkeitsdatum;
    }

    public void setGueligkeitsdatum(LocalDate gueligkeitsdatum) {
        this.gueligkeitsdatum = gueligkeitsdatum;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public List<Konto> getKontos() {
        return kontos;
    }
    public void setKontos(List<Konto> kontos) {
        this.kontos = kontos;
    }

    @Override
    public String toString() {
        return "Karte{" +
                "id=" + id +
                ", pin=" + pin +
                ", nummer=" + nummer +
                ", typ='" + typ + '\'' +
                ", gueligkeitsdatum=" + gueligkeitsdatum +
                ", cvc=" + cvc +
                ", kontos=" + kontos +
                '}';
    }
}
