package edu.obymas.projekt.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Games")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private long id;
	
	@Column(name = "Tournament_Id")
	private long t_id;
	
	@Column(name = "HomeTeam_Id")
	private long h_id;
	
	@Column(name = "GuestTeam_Id")
	private long g_id;
	
	@Column(name = "PlayDate")
	private Date pDate;
	
	@Column(name = "Result")
	private String result;
	
	@Column(name = "Winner")
	private int winner;

	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Game( long t_id, long h_id, long g_id, Date pDate, String result, int winner) {
		super();
		this.t_id = t_id;
		this.h_id = h_id;
		this.g_id = g_id;
		this.pDate = pDate;
		this.result = result;
		this.winner = winner;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getT_id() {
		return t_id;
	}

	public void setT_id(long t_id) {
		this.t_id = t_id;
	}

	public long getH_id() {
		return h_id;
	}

	public void setH_id(long h_id) {
		this.h_id = h_id;
	}

	public long getG_id() {
		return g_id;
	}

	public void setG_id(long g_id) {
		this.g_id = g_id;
	}

	public Date getpDate() {
		return pDate;
	}

	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getWinner() {
		return winner;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}
	
}
