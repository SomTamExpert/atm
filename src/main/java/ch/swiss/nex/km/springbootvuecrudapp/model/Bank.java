package ch.swiss.nex.km.springbootvuecrudapp.model;

import org.springframework.stereotype.Service;

import javax.persistence.*;

@Service
@Entity
@Table(name = "Bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "telefonnumer")
    private int telefonnumer;
    @Column(name = "bankleitzahl")
    private String bankleitzahl;

    public Bank() {
    }

    public Bank(String name, String adresse, int telefonnumer, String bankleitzahl) {
        this.name = name;
        this.adresse = adresse;
        this.telefonnumer = telefonnumer;
        this.bankleitzahl = bankleitzahl;
    }

    public void kontoLoeschen() {
        System.out.println("Ihr Bankkonto wurde gelöscht.");
    }

    public void kontoSperren() {
        System.out.println("Ihr Bankkonto wurde gesperrt.");
    }

    public void kontoVerwalten() {
        System.out.println("Konto verwalten");
    }

    public long getId() {
        return id;
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

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telefonnumer=" + telefonnumer +
                ", bankleitzahl='" + bankleitzahl + '\'' +
                '}';
    }
}
