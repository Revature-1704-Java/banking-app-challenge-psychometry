package com.raveture;

/**
 * TransactionDAO
 */
public interface TransactionDAO {
    public void deposit(Transaction deposit);
    public void withdraw(Transaction withdraw);
}