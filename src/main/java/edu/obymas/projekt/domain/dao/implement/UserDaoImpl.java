package edu.obymas.projekt.domain.dao.implement;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import edu.obymas.projekt.domain.dao.UserDao;
import edu.obymas.projekt.domain.model.User;


@Component("userDao")
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	@Override
    public User loadUserByUsername(String username) {
        Query query = this.entityManager
                .createQuery("select u FROM User u where u.username= :username");
        query.setParameter("username", username);
        List<User> users = query.getResultList();
        if (users != null && users.size() == 1) {
            return users.get(0);
        }
        return null;
    }
}