package edu.obymas.projekt.domain.dao.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.obymas.projekt.domain.model.BetToTake;
import edu.obymas.projekt.domain.model.Player;
import edu.obymas.projekt.domain.model.Team;
import edu.obymas.projekt.domain.model.Tournament;
import edu.obymas.projekt.domain.model.User;

@Component("tournamentDao")
@Transactional
public class TournamentDaoImpl extends GenericDaoImpl<Tournament>{
	
	public List<Tournament> getAllTournaments() {
		return (List<Tournament>)entityManager.createQuery("from Tournament").getResultList(); 
	}
	
	public Tournament crateTournament(String name) {
		Tournament tmp=new Tournament();
		tmp.setName(name);
		return this.create(tmp);
	}
	
	public List<Team> getAllTeamInTournament(long tournamentId) {
		  Query query = this.entityManager.createNativeQuery("Select t.Name, t.Id from "
				  +"hazardBase4.Tournaments as r "
				  +"join hazardBase4.Tournaments_has_Teams as rt on r.Id=rt.Tournament_Id "
				  +"join hazardBase4.Teams as t on t.Id=rt.Team_Id "
				  +"where r.Id=:tournamentId");
		  
		  query.setParameter("tournamentId", tournamentId);
		  
		  List<Object[]> results = query.getResultList();
	      
		  List<Team> teams=new ArrayList<Team>();
		  
		  for(Object[] result : results) {
			  if(result!=null)
				  teams.add(new Team((Integer)result[1], (String)result[0]));
		  }
		  
		  return teams;
	}
	
	public List<Team> getAllTeamNotInTournament(long tournamentId) {
		  Query query = this.entityManager.createNativeQuery("select * from hazardBase4.Teams as t where not exists ( "
				  +"Select * from "
				  +"hazardBase4.Tournaments_has_Teams as rt where "
				  +"rt.Team_Id=t.Id and rt.Tournament_Id=:tournamentId )");
		  
		  query.setParameter("tournamentId", tournamentId);
		  
		  List<Object[]> results = query.getResultList();
	      
		  List<Team> teams=new ArrayList<Team>();
		  
		  for(Object[] result : results) {
			  if(result!=null)
				  teams.add(new Team((Integer)result[0], (String)result[1]));
		  }
		  
		  return teams;
	}
	
}
