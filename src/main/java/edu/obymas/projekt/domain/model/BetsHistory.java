package edu.obymas.projekt.domain.model;

import java.util.Date;

public class BetsHistory {
	private String tournament;
	private String result;
	private int choice;
	private Date gameDate;
	private String hostTeam;
	private String guestTeam;
	private double betCash;
	private double homeLoad;
	private double guestLoad;
	private double drawLoad;
	private int winer;
	
	public BetsHistory(String tournament, String result, int choice, Date gameDate, String hostTeam, String guestTeam,
			double betCash, double homeLoad, double guestLoad, double drawLoad, int winer) {
		super();
		this.tournament = tournament;
		this.result = result;
		this.choice = choice;
		this.gameDate = gameDate;
		this.hostTeam = hostTeam;
		this.guestTeam = guestTeam;
		this.betCash = betCash;
		this.homeLoad = homeLoad;
		this.guestLoad = guestLoad;
		this.drawLoad = drawLoad;
		this.winer = winer;
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
	public double getBetCash() {
		return betCash;
	}
	public void setBetCash(double betCash) {
		this.betCash = betCash;
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
	public int getWiner() {
		return winer;
	}
	public void setWiner(int winer) {
		this.winer = winer;
	}
	public BetsHistory(String tournament, String result, int choice) {
		super();
		this.tournament = tournament;
		this.result = result;
		this.choice = choice;
	}
	public String getTournament() {
		return tournament;
	}
	public void setTournament(String tournament) {
		this.tournament = tournament;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getChoice() {
		return choice;
	}
	public void setChoice(int choice) {
		this.choice = choice;
	}
}
