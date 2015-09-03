package edu.obymas.projekt.domain.dao.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.obymas.projekt.domain.dao.PlayerDao;
import edu.obymas.projekt.domain.model.Bet;
import edu.obymas.projekt.domain.model.Game;
import edu.obymas.projekt.domain.model.Player;

@Component("gameDao")
public class GameDaoImpl extends GenericDaoImpl<Game>{
	
	@Autowired
	private PlayerDao playerDao;
	
	@Autowired
	private BetDaoImpl betDao;
	
	public Game creatGame(long idT, long h, long g, Date d) {
		Game game=new Game(idT,h,g,d,"",0);
		return this.create(game);
	}
	
	public Game updateGame(long id,String result, int winner) {
		Game game=this.find(id);
		game.setResult(result);
		game.setWinner(winner);
		
		Query query = this.entityManager.createNativeQuery("select u.User_Id, u.Account, c.Bet_Choose, c.BetCash from "
							+"Coupons as c join Players as u on u.User_id=c.Player_User_Id "
							+"where c.Bet_Game_Id=:gameId ");
		  
		  query.setParameter("gameId", id);
		  
		  List<Object[]> results = query.getResultList();
	      
		  List<Player> bettingPlayer=new ArrayList<Player>();
		  Bet bet=betDao.find(id);
		  double load=0;
		  switch(winner){
		  	case 1:
		  		load=bet.getHomeLoad();
		  		break;
		  	case 2:
		  		load=bet.getGuestLoad();
		  		break;
		  	case 3:
		  		load=bet.getDrawLoad();
		  		break;
		  }
		  for(Object[] result1 : results) {
			  if(result1!=null)
			  	  if((Integer)result1[2]==winner) {
			  		  playerDao.updateAccount((Integer)result1[0],load*(Double)result1[3]);
			  	  }
		  }
		return this.update(game);
	}
}