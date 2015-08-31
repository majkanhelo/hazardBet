package edu.obymas.projekt.domain.dao;

import java.util.List;

import edu.obymas.projekt.domain.model.Role;

public interface RoleDAO extends GenericDao<Role> {
	
	/**
     * Returns an User object that matches the username given
     *
     * @param rolename
     * @return
     */
    public Role loadRoleByRolename(String rolename);
    public List<Role> getAllRoles();
    
}
