package edu.obymas.projekt.domain.dao.implement;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.obymas.projekt.domain.model.Player;
import edu.obymas.projekt.domain.model.Team;
import edu.obymas.projekt.domain.model.Tournament;
import edu.obymas.projekt.domain.model.User;

@Component("tournamentDao")
public class TournamentDaoImpl extends GenericDaoImpl<Tournament>{
	
	public List<Tournament> getAllTournaments() {
		return (List<Tournament>)entityManager.createQuery("from Tournament").getResultList(); 
	}

	public Tournament crateTournament(String name) {
		Tournament tmp=new Tournament();
		tmp.setName(name);
		return this.create(tmp);
	}
}
