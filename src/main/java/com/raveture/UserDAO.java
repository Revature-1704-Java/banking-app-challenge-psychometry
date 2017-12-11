package com.raveture;

/**
 * UserDAO
 */
public interface UserDAO {
    public void insert(User user);
    public void update(User user);
    public void delete(User user);
}