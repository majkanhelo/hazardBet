package edu.obymas.projekt.domain.dao.implement;

import org.springframework.stereotype.Component;

import edu.obymas.projekt.domain.model.Player;
import edu.obymas.projekt.domain.model.Team;

@Component("teamDao")
public class TeamDaoImpl extends GenericDaoImpl<Team>{
	
	public Team crateTeam(String teamName) {
		Team tmp=new Team();
		tmp.setName(teamName);
		return this.create(tmp);
	}

}
