package com.example.lib001;

import java.util.Date;
public class Account {

    private int id;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated;

    public Account() {
        this.id = 0;
        this.balance = 0;
        this.dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double rate) {
        annualInterestRate = rate;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public static double getMonthlyInterestRate() {
        return (annualInterestRate / 12);
    }

    public double getMonthlyInterest() {
        return (this.balance * getMonthlyInterestRate()/100);
    }

    public void withdraw(double amt) {
        this.balance = this.balance - amt;
    }
    public void deposit(double amt) {
        this.balance = this.balance + amt;
    }

    public double getBalance() {
        return this.balance;
    }

}

