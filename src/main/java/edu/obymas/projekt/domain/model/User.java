package edu.obymas.projekt.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 8874529711237619334L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usr_id")
	private long id;
	
	@Column(name = "usr_login")
	private String login;
	
	@Column(name = "usr_password")
	private String password;
	
	@ManyToOne
    @JoinColumn(name="usr_rol_id", referencedColumnName = "rol_id")
	private Role role;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "usr_status")
	private UserStatus status;
	
	public User() {}

	public User(long id, String login, String password, Role role, UserStatus status) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.role = role;
		this.status = status;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public UserStatus getStatus() {
		return status;
	}
	public void setStatus(UserStatus status) {
		this.status = status;
	}

}
