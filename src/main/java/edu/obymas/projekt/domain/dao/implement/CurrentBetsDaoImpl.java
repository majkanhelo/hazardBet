package edu.obymas.projekt.domain.dao.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import edu.obymas.projekt.domain.model.CurrentBet;
import edu.obymas.projekt.domain.model.Player;

@Component("currentBetsDao")
public class CurrentBetsDaoImpl extends GenericDaoImpl<Player> {

	public List<CurrentBet> getPlayerCurrentBets(long userId) {
		  Query query = this.entityManager.createNativeQuery("Select t.Name, c.Bet_Choose, g.PlayDate, "
        		+" h.Name as home, o.Name as guest, c.BetCash, b.DrawLoad, b.HomeLoad, b.GuestLoad "
				+"from Coupons as c "
        		+"join Bets as b on c.Bet_Game_Id=b.Game_Id "
        		+"join Games as g on g.Id=b.Game_Id "
        		+"join Tournaments as t on g.Tournament_Id=t.Id "
        		+"join Teams as h on h.Id=g.HomeTeam_Id "
        		+"join Teams as o on o.Id=g.GuestTeam_Id "
        		+"where c.Player_User_Id=:userId and b.Resolved=false");
		  
		  query.setParameter("userId", userId);
		  
		  List<Object[]> results = query.getResultList();
	      
		  List<CurrentBet> currentBets=new ArrayList<CurrentBet>();
		  
		  for(Object[] result : results) {
			  if(result!=null)
				  currentBets.add(new CurrentBet((String)result[0], (Integer)result[1], 
					  (Date)result[2], (String)result[3], (String)result[4], (Double)result[5], 
					  (Double)result[6], (Double)result[7], (Double)result[8]) );
		  }
		  
		  return currentBets;
	}
	
}
