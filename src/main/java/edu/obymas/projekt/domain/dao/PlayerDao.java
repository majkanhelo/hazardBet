package edu.obymas.projekt.domain.dao;

import edu.obymas.projekt.domain.model.Player;

public interface PlayerDao extends GenericDao<Player> {
	
	public double getPlayerAccount(long id);
	public void updateAccount(long id, double change);
}

