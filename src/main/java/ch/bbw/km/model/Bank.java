package ch.bbw.km.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Bank {


    private String name;
    private String adresse;
    private int telefonnumer;
    private String bankleitzahl;
    public List<Kunde> kunden = new ArrayList<>(
    );
    public Bank() {
    }

    public Bank(String name, String adresse, int telefonnumer, String bankleitzahl, List<Kunde> kunden) {
        this.name = name;
        this.adresse = adresse;
        this.telefonnumer = telefonnumer;
        this.bankleitzahl = bankleitzahl;
        this.kunden = kunden;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTelefonnumer() {
        return telefonnumer;
    }

    public void setTelefonnumer(int telefonnumer) {
        this.telefonnumer = telefonnumer;
    }

    public String getBankleitzahl() {
        return bankleitzahl;
    }

    public void setBankleitzahl(String bankleitzahl) {
        this.bankleitzahl = bankleitzahl;
    }

    public List<Kunde> getKunden() {
        return kunden;
    }

    public void setKunden(List<Kunde> kunden) {
        this.kunden = kunden;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telefonnumer=" + telefonnumer +
                ", bankleitzahl='" + bankleitzahl + '\'' +
                ", kunden=" + kunden +
                '}';
    }
}
