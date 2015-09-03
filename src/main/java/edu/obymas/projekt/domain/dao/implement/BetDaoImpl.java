package edu.obymas.projekt.domain.dao.implement;

import org.springframework.stereotype.Component;

import edu.obymas.projekt.domain.model.Bet;
import edu.obymas.projekt.domain.model.Coupon;

@Component("betDao")
public class BetDaoImpl extends GenericDaoImpl<Bet>{
	
	public void creatBet(long idGame, double h, double g, double d) {
		Bet bet=new Bet(idGame,h,g,d,false);
		this.create(bet);
	}
	
	public void updateBet(long idGame) {
		Bet bet=this.find(idGame);
		bet.setResolved(true);
		this.update(bet);
	}
}