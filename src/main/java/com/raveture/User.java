package com.raveture;

import java.util.HashMap;

/**
 * User
 */

public class User {
    private static int currentId=1;
    private String name;
    private int id;
    private HashMap<Integer, Account> accounts;
    public User(){};
    public User(String name){
        this.id=currentId++;
        this.name=name;
        this.accounts = new HashMap<>();
    }
    public void addAccount(){
        Account temp= new Account();
        this.accounts.put(temp.getId(),temp);
    }
    public void deletAccount(int accountId){
        this.accounts.remove(accountId);
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
}