package edu.obymas.projekt.domain.service;

import java.util.List;

import edu.obymas.projekt.domain.model.User;

public interface UserService {

    User createUser(String username, String password, String roleName);
    User updateUser(String username, String password, String roleName,Long id);
    public User getUser(Long id);
    public List<User> getAllUsers();
	User updateUser(User user);
	User loadUserByUsername(String username);
    public User findUserByUsername(String username);
    public void deleteUser(long id);

}
