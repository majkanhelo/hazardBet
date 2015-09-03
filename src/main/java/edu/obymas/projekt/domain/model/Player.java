package edu.obymas.projekt.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Players")
public class Player {
	
	@Id
	@Column(name = "User_Id")
	private long id;
	
	public long getId() {
		return id;
	}

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setId(long id) {
		this.id = id;
	}

	public Player(long id, double account) {
		super();
		this.id = id;
		this.account = account;
	}

	@Column(name = "Account")
	private double account;

	public double getAccount() {
		return account;
	}

	public void setAccount(double account) {
		this.account = account;
	}
	
}

