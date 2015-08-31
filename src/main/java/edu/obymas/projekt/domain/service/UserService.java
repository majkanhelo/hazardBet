package edu.obymas.projekt.domain.service;

import java.util.List;

import edu.obymas.projekt.domain.model.User;

public interface UserService {

    void createUser(String username, String userPassword);
    public User getUser(Long id);
    public List<User> getAllUsers();
	void updateUser(User user);
	User loadUserByUsername(String username);
}
