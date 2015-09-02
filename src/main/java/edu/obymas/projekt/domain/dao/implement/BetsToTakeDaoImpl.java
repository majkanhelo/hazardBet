package edu.obymas.projekt.domain.dao.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import edu.obymas.projekt.domain.model.BetToTake;
import edu.obymas.projekt.domain.model.Player;

@Component("betsToTakeDao")
public class BetsToTakeDaoImpl extends GenericDaoImpl<Player>{
	
	public List<BetToTake> getBetsToTake() {
		  Query query = this.entityManager.createNativeQuery("Select t.Name as Tournament, g.PlayDate, "
				  +"h.Name as Home, o.Name as Geust, b.DrawLoad, b.HomeLoad, b.GuestLoad, b.Game_Id "
				  +"from hazardBase4.Bets as b " 
				  +"join hazardBase4.Games as g on g.Id=b.Game_Id "
				  +"join hazardBase4.Tournaments as t on g.Tournament_Id=t.Id "
				  +"join hazardBase4.Teams as h on h.Id=g.HomeTeam_Id "
				  +"join hazardBase4.Teams as o on o.Id=g.GuestTeam_Id "
				  +"where b.Resolved=false");
		  
		  List<Object[]> results = query.getResultList();
	      
		  List<BetToTake> betToTake=new ArrayList<BetToTake>();
		  
		  for(Object[] result : results) {
			  if(result!=null)
				  betToTake.add(new BetToTake((String)result[0], (Date)result[1], (String)result[2], 
					  (String)result[3], (Double)result[4], (Double)result[5], 
					  (Double)result[6], (Integer)result[7]));
		  }
		  
		  return betToTake;
	}
	
}
