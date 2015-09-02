package edu.obymas.projekt.domain.dao.implement;

import org.springframework.stereotype.Component;

import edu.obymas.projekt.domain.dao.PlayerDao;
import edu.obymas.projekt.domain.model.Player;


@Component("playerDao")
public class PlayerDaoImpl extends GenericDaoImpl<Player> implements PlayerDao {
	
	@Override
	public double getPlayerAccount(long id) {
		Player gotPlayer=this.find(id);
		return gotPlayer.getAccount();
	}
	
}
