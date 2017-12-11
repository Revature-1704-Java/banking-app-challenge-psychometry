package com.raveture;

import java.util.HashMap;
import java.util.Set;

/**
 * User
 */

public class User {
    private static int currentId=1;
    private String name;
    private int id;
    HashMap<Integer, Account> accounts;
    public User(){};
    public User(String name){
        this.id=currentId++;
        this.name=name;
        this.accounts = new HashMap<>();
    }
    public int addAccount(){
        Account temp= new Account();
        this.accounts.put(temp.getId(),temp);
        return temp.getId();
    }
    public void deletAccount(int accountId){
        this.accounts.remove(accountId);
    }
    public int getNumAccounts(){
        return accounts.size();
    }
    public Set getAccountIds(){
        return accounts.keySet();
    }
    public Account getAccount(int id){
        return accounts.get(id);
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