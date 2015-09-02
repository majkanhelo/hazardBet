package edu.obymas.projekt.domain.service;

import edu.obymas.projekt.domain.model.Player;

public interface PlayerService {
	
	public double getPlayerAccount(long id);
	public void updatePlayerAccount(Player player);
	public void createPlayer(long userId);
	public Player findPlayer(long id);
	public void deletePlayer(long id);
}
