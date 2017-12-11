package com.raveture;

/**
 * AccountDAO
 */
public interface AccountDAO {
    public boolean insert(Account account);
    public boolean update(Account account);
    public boolean delete(Account account);
}