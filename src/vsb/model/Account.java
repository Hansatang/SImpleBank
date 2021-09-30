/*
 * 12.09.2018 Original version
 */


package vsb.model;

import java.io.Serializable;

public class Account implements Serializable {
    private int number;
    private double balance;

    public Account(int number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public void updateBalance(double amount) {
        balance = Math.round((balance + amount) * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", balance=" + balance +
                '}';
    }
}
