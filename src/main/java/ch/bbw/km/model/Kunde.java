package ch.bbw.km.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Kunde {

    @NotEmpty
    @Size(min = 2, max = 20)
    private String vorname;
    @NotEmpty
    @Size(min = 2, max = 20)
    private String nachname;
    @NotEmpty
    private String strasseNummer;
    @Pattern(regexp = "[0-9]{4}", message = "muss 4 Stellen sein")
    private String plz;
    @NotEmpty
    private String land;
    @NotEmpty
    private String ort;
    @Pattern(regexp = "^(0041|041|\\+41|\\+\\+41|41)?(0|\\(0\\))?([1-9]\\d{1})(\\d{3})(\\d{2})(\\d{2})$", message = "Bitte geben Sie eine Schweizer Telefonnummer ein!")
    private String telefonnummer;
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Verwenden Sie ein richtiges Format: xxxx@xx.xx")
    private String email;
    private Konto konto;
    private Karte karte;

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

    public String getStrasseNummer() {
        return strasseNummer;
    }

    public void setStrasseNummer(String strasseNummer) {
        this.strasseNummer = strasseNummer;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
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

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }

    public Karte getKarte() {
        return karte;
    }

    public void setKarte(Karte karte) {
        this.karte = karte;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", strasseNummer='" + strasseNummer + '\'' +
                ", plz=" + plz +
                ", land='" + land + '\'' +
                ", ort='" + ort + '\'' +
                ", telefonnummer='" + telefonnummer + '\'' +
                ", email='" + email + '\'' +
                ", konto=" + konto +
                ", karte=" + karte +
                '}';
    }
}
