package ch.bbw.km.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Transaktion")
public class Transaktion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Konto gutschriftskonto;
    @ManyToOne(fetch = FetchType.LAZY)
    private Konto belastungskonto;
    @Column(name = "zeitpunkt")
    private LocalDateTime zeitpunkt;
    @Column(name = "betrag")
    private double betrag;
    @Column(name = "waehrung")
    private String waehrung;
    @Enumerated(EnumType.STRING)
    public TransTyp transTyptyp;

    public Transaktion() {
    }

    public Transaktion(Konto gutschriftskonto, Konto belastungskonto, LocalDateTime zeitpunkt, double betrag, String waehrung, TransTyp transTyptyp) {
        this.gutschriftskonto = gutschriftskonto;
        this.belastungskonto = belastungskonto;
        this.zeitpunkt = zeitpunkt;
        this.betrag = betrag;
        this.waehrung = waehrung;
        this.transTyptyp = transTyptyp;
    }

    public void waehrungSetzen() {
    }

    public void kontoSetzen() {
    }

    public void belastung() {
    }

    public void gutschreiben() {
    }

    public long getId() {
        return id;
    }

    public Konto getGutschriftskonto() {
        return gutschriftskonto;
    }

    public void setGutschriftskonto(Konto gutschriftskonto) {
        this.gutschriftskonto = gutschriftskonto;
    }

    public Konto getBelastungskonto() {
        return belastungskonto;
    }

    public void setBelastungskonto(Konto belastungskonto) {
        this.belastungskonto = belastungskonto;
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


    @Override
    public String toString() {
        return "Transaktion{" +
                "id=" + id +
                ", gutschriftskonto=" + gutschriftskonto +
                ", belastungskonto=" + belastungskonto +
                ", zeitpunkt=" + zeitpunkt +
                ", betrag=" + betrag +
                ", waehrung='" + waehrung + '\'' +
                '}';
    }
}
