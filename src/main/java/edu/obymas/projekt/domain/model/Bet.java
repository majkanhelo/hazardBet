package edu.obymas.projekt.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bets")
public class Bet {
	
	@Id
	@Column(name = "Game_Id")
	private long Game_Id;
	
	@Column(name = "HomeLoad")
	private double HomeLoad;
	
	@Column(name = "GuestLoad")
	private double GuestLoad;
	
	@Column(name = "DrawLoad")
	private double DrawLoad;
	
	@Column(name = "Resolved")
	private boolean Resolved;

	public long getGame_Id() {
		return Game_Id;
	}

	public void setGame_Id(long game_Id) {
		Game_Id = game_Id;
	}

	public double getHomeLoad() {
		return HomeLoad;
	}

	public void setHomeLoad(double homeLoad) {
		HomeLoad = homeLoad;
	}

	public double getGuestLoad() {
		return GuestLoad;
	}

	public void setGuestLoad(double guestLoad) {
		GuestLoad = guestLoad;
	}

	public double getDrawLoad() {
		return DrawLoad;
	}

	public void setDrawLoad(double drawLoad) {
		DrawLoad = drawLoad;
	}

	public boolean isResolved() {
		return Resolved;
	}

	public void setResolved(boolean resolved) {
		Resolved = resolved;
	}

	public Bet(long game_Id, double homeLoad, double guestLoad, double drawLoad, boolean resolved) {
		super();
		Game_Id = game_Id;
		HomeLoad = homeLoad;
		GuestLoad = guestLoad;
		DrawLoad = drawLoad;
		Resolved = resolved;
	}

	public Bet() {
		super();
	} 
}
