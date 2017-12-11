package com.raveture;
/**
 * Account
 */

import java.util.HashMap;
import java.util.Map;

public class Account {
    private static int currentId=1;
    private int id;
    private HashMap<Integer,Transaction> transactions;
    private double balance;
    public Account(){
        this.id=currentId++;
        transactions=new HashMap<Integer,Transaction>();
        this.balance=0;
    }
    public void addTransaction(Transaction t){
        transactions.put(t.getId(), t);
        double temp=0;
        for (Map.Entry<Integer, Transaction> entry : transactions.entrySet()){
            temp+=entry.getValue().getAmount();
        }
        balance=temp;
    }
    public int getId(){
        return this.id;
    }
    public double getBalance(){
        return this.balance;
    }
}