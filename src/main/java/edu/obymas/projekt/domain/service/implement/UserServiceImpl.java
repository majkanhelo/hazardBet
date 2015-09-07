package edu.obymas.projekt.domain.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.obymas.projekt.domain.dao.PlayerDao;
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
    
    @Autowired
    private PlayerDao playerDao;

    @Override
    public User createUser(String userName, String password, String roleName) {

    	User user = new User();
    	Role role = roleDAO.loadRoleByRolename(roleName);
    	
    	user.setLogin(userName);
    	user.setPassword(password);
    	user.setStatus(UserStatus.ACTIVE);
    	user.setRole(role);
    	
    	return userDao.create(user);
    }
    
    @Override
    public User loadUserByUsername(String username) {
    	return userDao.loadUserByUsername(username);
    }
    
    @Override
	public User getUser(Long id) {
		User user = userDao.find(id);
		return user;
	}
    
    @Override
	public User updateUser(User user) {
		return userDao.update(user);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = userDao.getAllUsers();
		return allUsers;
	}
	
	@Override
	public User findUserByUsername(String username){
		return userDao.loadUserByUsername(username);
	}
	
	@Override
	public User updateUser(String username, String password, String roleName,Long id){
		
		User user=this.getUser(id);
		Role role = roleDAO.loadRoleByRolename(roleName);
    	
    	user.setLogin(username);
    	
    	user.setPassword(password);
    	user.setStatus(UserStatus.ACTIVE);
    	user.setRole(role);
    	
    	return userDao.update(user);
	}
	
	@Override
	public void deleteUser(long id) {
		if(playerDao.find(id)!=null){
			playerDao.delete(id);
		}
		userDao.delete(id);
	}

}