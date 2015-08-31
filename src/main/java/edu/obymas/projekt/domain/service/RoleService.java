package edu.obymas.projekt.domain.service;

import java.util.List;

import edu.obymas.projekt.domain.model.Role;

public interface RoleService {

    void createUser(String roleName);
    public Role getRole(Long id);
    public List<Role> getAllRoles();
	void updateRole(Role role);
	Role loadRoleByRolename(String roleName);
}
