package com.raveture;

/**
 * Transactions
 */
public class Transaction {
    private static int currentId=1;
    private int id;
    private double amount;
    public Transaction(){
    }
    public Transaction(double amount){
        this.id = currentId++;
        this.amount=amount;       
    }
    public int getId(){
        return this.id;
    }
    public double getAmount(){
        return this.amount;
    }

}