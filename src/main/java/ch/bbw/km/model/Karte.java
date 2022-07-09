package ch.bbw.km.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Karte")
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Karte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "pin")
    private String pin;
    @Column(name = "nummer")
    private String nummer;
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
    public Karte(String pin, String nummer, String typ, LocalDate gueligkeitsdatum, int cvc) {
        this.pin = pin;
        this.nummer = nummer;
        this.typ = typ;
        this.gueligkeitsdatum = gueligkeitsdatum;
        this.cvc = cvc;
    }

    public long getId() {
        return id;
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
