package ch.bbw.km.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Account is used to store the account data of a client.
 * @author marco karpf
 * @version 12.07.2022
 */
@Component
public class Account {

    private String typ;
    private int number;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Account{" +
                "typ='" + typ + '\'' +
                ", number=" + number +
                ", balance=" + balance +
                ", transactions=" + transactions +
                '}';
    }
}
