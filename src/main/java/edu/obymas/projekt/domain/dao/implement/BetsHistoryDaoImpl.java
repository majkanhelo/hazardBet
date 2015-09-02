package edu.obymas.projekt.domain.dao.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import edu.obymas.projekt.domain.dao.PlayerDao;
import edu.obymas.projekt.domain.model.BetsHistory;
import edu.obymas.projekt.domain.model.Player;
import edu.obymas.projekt.domain.model.User;

@Component("betsHistoryDao")
public class BetsHistoryDaoImpl extends GenericDaoImpl<Player>{
	
	public List<BetsHistory> getPlayerBetsHistory(long userId) {
		  Query query = this.entityManager.createNativeQuery("Select t.Name, g.Result, c.Bet_Choose, g.PlayDate, "
          		+" h.Name as home, o.Name as guest, c.BetCash, b.DrawLoad, b.HomeLoad, b.GuestLoad, g.Winner "
				+"from Coupons as c "
          		+"join Bets as b on c.Bet_Game_Id=b.Game_Id "
          		+"join Games as g on g.Id=b.Game_Id "
          		+"join Tournaments as t on g.Tournament_Id=t.Id "
          		+"join Teams as h on h.Id=g.HomeTeam_Id "
          		+"join Teams as o on o.Id=g.GuestTeam_Id "
          		+"where c.Player_User_Id=:userId and b.Resolved=true");
		  
		  query.setParameter("userId", userId);
		  
		  List<Object[]> results = query.getResultList();
	      
		  List<BetsHistory> betsHistory=new ArrayList<BetsHistory>();
		  
		  for(Object[] result : results) {
			  if(result!=null)
				  betsHistory.add(new BetsHistory((String)result[0], (String)result[1], (Integer)result[2], 
					  (Date)result[3], (String)result[4], (String)result[5], (Double)result[6], 
					  (Double)result[7], (Double)result[8], (Double)result[9], (Integer)result[10]));
		  }
		  
		  return betsHistory;
	}
	
}
