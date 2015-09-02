package edu.obymas.projekt.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Coupons")
public class Coupon {
	
	@Id
	@Column(name = "Id")
	private long Id;
	
    @Column(name="Bet_Game_Id")
	private long GameId;
	
	@Column(name = "Player_User_Id")
	private long UserId;
	
	@Column(name = "Bet_Choose")
	private int Choose;
	
	@Column(name = "BetCash")
	private double Cash;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getGameId() {
		return GameId;
	}

	public void setGameId(long gameId) {
		GameId = gameId;
	}

	public long getUserId() {
		return UserId;
	}

	public void setUserId(long userId) {
		UserId = userId;
	}

	public int getChoose() {
		return Choose;
	}

	public void setChoose(int choose) {
		Choose = choose;
	}

	public double getCash() {
		return Cash;
	}

	public void setCash(double cash) {
		Cash = cash;
	}
	
}
