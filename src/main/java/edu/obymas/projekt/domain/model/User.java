package edu.obymas.projekt.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue
	private long id;
	private String userName;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
