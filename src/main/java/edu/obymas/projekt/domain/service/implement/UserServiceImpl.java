package edu.obymas.projekt.domain.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.obymas.projekt.domain.dao.UserDao;
import edu.obymas.projekt.domain.model.User;
import edu.obymas.projekt.domain.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public void createUser(User u) {
        dao.create(u);
    }
}