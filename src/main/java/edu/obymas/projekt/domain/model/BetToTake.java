package edu.obymas.projekt.domain.model;

import java.util.Date;

public class BetToTake {
	private String tournament;
	private Date gameDate;
	private String hostTeam;
	private String guestTeam;
	private double homeLoad;
	private double guestLoad;
	private double drawLoad;
	private int gameId;
	
	public BetToTake(String tournament, Date gameDate, String hostTeam, String guestTeam, double homeLoad,
			double guestLoad, double drawLoad, int gameId) {
		super();
		this.tournament = tournament;
		this.gameDate = gameDate;
		this.hostTeam = hostTeam;
		this.guestTeam = guestTeam;
		this.homeLoad = homeLoad;
		this.guestLoad = guestLoad;
		this.drawLoad = drawLoad;
		this.gameId = gameId;
	}
	public String getTournament() {
		return tournament;
	}
	public void setTournament(String tournament) {
		this.tournament = tournament;
	}
	public Date getGameDate() {
		return gameDate;
	}
	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}
	public String getHostTeam() {
		return hostTeam;
	}
	public void setHostTeam(String hostTeam) {
		this.hostTeam = hostTeam;
	}
	public String getGuestTeam() {
		return guestTeam;
	}
	public void setGuestTeam(String guestTeam) {
		this.guestTeam = guestTeam;
	}
	public double getHomeLoad() {
		return homeLoad;
	}
	public void setHomeLoad(double homeLoad) {
		this.homeLoad = homeLoad;
	}
	public double getGuestLoad() {
		return guestLoad;
	}
	public void setGuestLoad(double guestLoad) {
		this.guestLoad = guestLoad;
	}
	public double getDrawLoad() {
		return drawLoad;
	}
	public void setDrawLoad(double drawLoad) {
		this.drawLoad = drawLoad;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
}
