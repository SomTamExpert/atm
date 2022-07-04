package ch.swiss.nex.km.springbootvuecrudapp.model;

import javax.persistence.*;

@Entity
@Table(name = "Erlaubnis")
public class Erlaubnis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "beschreibung")
    private String beschreibung;
    @Enumerated(EnumType.STRING)
    private Rolle rolle;

    public Erlaubnis() {
    }

    public Erlaubnis(String title, String beschreibung) {
        this.title = title;
        this.beschreibung = beschreibung;
    }

    public void kartenLesem(){}
    public boolean kundenIdentifizieren(String pin, int nummer){
        return true;
    }

    public long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    @Override
    public String toString() {
        return "Erlaubnis{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", beschreibung='" + beschreibung + '\'' +
                '}';
    }
}
