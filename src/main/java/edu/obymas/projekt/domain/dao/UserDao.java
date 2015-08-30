package edu.obymas.projekt.domain.dao;

import java.util.List;

import edu.obymas.projekt.domain.model.User;

public interface UserDao extends GenericDao<User> {
    /**
     * Returns an User object that matches the username given
     *
     * @param username
     * @return
     */
    public User loadUserByUsername(String username);
    public List<User> getAllUsers();
}