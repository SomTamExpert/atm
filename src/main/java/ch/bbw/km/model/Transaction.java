package ch.bbw.km.model;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component

public class Transaction {


    private LocalDateTime timestamp;
    private double amount;
    private String currency;
    private String typ;

    public Transaction() {
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "timestamp=" + timestamp +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", typ='" + typ + '\'' +
                '}';
    }
}
