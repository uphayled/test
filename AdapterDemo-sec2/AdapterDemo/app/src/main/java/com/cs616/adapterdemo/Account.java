package com.cs616.adapterdemo;

/**
 * Created by ian.clement on 2015-09-14.
 */
public class Account {

    private long accoutNumber;
    protected double balance;

    public Account(long accoutNumber, double balance) {
        this.accoutNumber = accoutNumber;
        this.balance = balance;
    }

    public long getAccoutNumber() {
        return accoutNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        if (amt < 0)
            return; // TODO: 2015-09-14 throw exception
        balance += amt;
    }

    public void withdraw(double amt) {
        if (amt < 0)
            return; // TODO: 2015-09-14 throw exception
        if (balance - amt < 0)
            return; // TODO: 2015-09-14 throw a different exception
        balance -= amt;
    }
}
