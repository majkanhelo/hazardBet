package edu.obymas.projekt.domain.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.obymas.projekt.domain.dao.RoleDAO;
import edu.obymas.projekt.domain.model.Role;
import edu.obymas.projekt.domain.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
    private RoleDAO roleDAO;
	
	@Override
	public void createUser(String roleName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role getRole(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role loadRoleByRolename(String roleName) {
		return roleDAO.loadRoleByRolename(roleName);
	}

}
