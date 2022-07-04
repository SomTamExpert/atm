package ch.swiss.nex.km.springbootvuecrudapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Kunde")
public class Kunde {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "vorname")
    private String vorname;
    @Column(name = "nachname")
    private String nachname;
    @Column(name = "stasseNummer")
    private String stasseNummer;
    @Column(name = "plz")
    private int plz;
    @Column(name = "land")
    private String land;
    @Column(name = "telefonnummer")
    private String telefonnummer;
    @Column(name = "email")
    private String email;
    @OneToMany()
    private List<Konto> kontos = new ArrayList<>();

    public Kunde() {
    }

    public Kunde(String vorname, String nachname, String stasseNummer, int plz, String land, String telefonnummer, String email, List<Konto> kontos) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.stasseNummer = stasseNummer;
        this.plz = plz;
        this.land = land;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.kontos = kontos;
    }

    public void kontoAuswaehlen(){}
    public void kontoInfoAnzeigen(){}
    public void pinAendern(){}
    public void bezugInEuro(){}
    public void bezugInCHF(){}
    public void korrigieren(){}
    public void bestaetigen(){}
    public void abbrechen(){}
    public void betragEingeben(){}
    public void belegDrucken(){}
    public void kontoAendern(){}
    public void kontoEroeffnen(){}
    public void transaktionStarten(){}
    public void letztetansaktionenAnzeigen(){}

    public long getId() {
        return id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getStasseNummer() {
        return stasseNummer;
    }

    public void setStasseNummer(String stasseNummer) {
        this.stasseNummer = stasseNummer;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Konto> getKontos() {
        return kontos;
    }

    public void setKontos(List<Konto> kontos) {
        this.kontos = kontos;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "id=" + id +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", stasseNummer='" + stasseNummer + '\'' +
                ", plz=" + plz +
                ", land='" + land + '\'' +
                ", telefonnummer='" + telefonnummer + '\'' +
                ", email='" + email + '\'' +
                ", kontos=" + kontos +
                '}';
    }
}
