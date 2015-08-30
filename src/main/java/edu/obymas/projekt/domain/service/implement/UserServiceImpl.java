package edu.obymas.projekt.domain.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.obymas.projekt.domain.dao.RoleDAO;
import edu.obymas.projekt.domain.dao.UserDao;
import edu.obymas.projekt.domain.model.Role;
import edu.obymas.projekt.domain.model.User;
import edu.obymas.projekt.domain.model.UserStatus;
import edu.obymas.projekt.domain.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private RoleDAO roleDAO;

    @Override
    public void createUser(String userName) {
    	User user = new User();
    	Role role = roleDAO.loadRoleByRolename("Player");
    	
    	user.setLogin(userName);
    	
//    	user.setRole_Id(2);
//    	user.setUserPassword("obymas");
    	
    	user.setPassword("obymas");
    	user.setStatus(UserStatus.ACTIVE);
    	user.setRole(role);
    	
    	userDao.create(user);
    }
    
    @Override
	public User getUser(Long id) {
		User user = userDao.find(id);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = userDao.getAllUsers();
		
		return allUsers;
	}

}