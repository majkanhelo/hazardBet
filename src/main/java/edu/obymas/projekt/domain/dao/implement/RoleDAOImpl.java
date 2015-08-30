package edu.obymas.projekt.domain.dao.implement;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import edu.obymas.projekt.domain.dao.RoleDAO;
import edu.obymas.projekt.domain.model.Role;

@Component("roleDAO")
public class RoleDAOImpl extends GenericDaoImpl<Role> implements RoleDAO {

	@Override
	public Role loadRoleByRolename(String name) {
		
		Query query = this.entityManager
                .createQuery("FROM Role r where r.name= :name");
        query.setParameter("name", name);
        List<Role> roles = query.getResultList();
        if (roles != null && roles.size() == 1) {
            return roles.get(0);
        }
        return null;
	}

	@Override
	public List<Role> getAllRoles() {
		return (List<Role>)entityManager.createQuery("from Role").getResultList(); 
	}

}
