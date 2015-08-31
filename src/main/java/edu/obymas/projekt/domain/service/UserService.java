package edu.obymas.projekt.domain.service;

import java.util.List;

import edu.obymas.projekt.domain.model.User;

public interface UserService {

    void createUser(String username, String password, String roleName);
    void updateUser(String username, String password, String roleName,Long id);
    public User getUser(Long id);
    public List<User> getAllUsers();
    public User findUserByUsername(String username);
}
