package edu.obymas.projekt.domain.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Role implements Serializable {
	
	private static final long serialVersionUID = 5500405887413331116L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rol_id")
	private int id;
	
	@Column(name = "rol_name")
	private String name;
	
	@OneToMany(mappedBy = "role")
    private Set<User> users;

	public Role() {}

	public Role(int id, String name, Set<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
	
}
