package edu.obymas.projekt.domain.dao.implement;

import java.util.Date;

import org.springframework.stereotype.Component;

import edu.obymas.projekt.domain.model.Bet;
import edu.obymas.projekt.domain.model.Coupon;
import edu.obymas.projekt.domain.model.Game;

@Component("gameDao")
public class GameDaoImpl extends GenericDaoImpl<Game>{
	
	public Game creatGame(long idT, long h, long g, Date d) {
		Game game=new Game(idT,h,g,d,"",0);
		return this.create(game);
	}
}