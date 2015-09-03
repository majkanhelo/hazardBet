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
import edu.obymas.projekt.domain.model.TournamentTeam;
import edu.obymas.projekt.domain.model.TournamentTeamId;
import edu.obymas.projekt.domain.model.User;

@Component("tournamentTeamDao")
public class TournamentTeamDaoImpl extends GenericDaoImpl<TournamentTeam> {

	@Transactional
	public void addTeamToTournament(long tournamentId, long teamId) {

		this.entityManager.getTransaction().begin();
		String querySt = "Insert into Tournaments_has_Teams values( " + tournamentId + "," + teamId + ")";
		Query query = this.entityManager.createNativeQuery(querySt);
		query.executeUpdate();
		this.entityManager.getTransaction().commit();
	}

	@Transactional
	public void deleteTeamFromTournament(long tournamentId, long teamId) {
		this.entityManager.getTransaction().begin();
		String querySt = "DELETE FROM Tournaments_has_Teams WHERE Tournament_Id=" + tournamentId
				+ " AND Team_Id=" + teamId;
		Query query = this.entityManager.createNativeQuery(querySt);
		query.executeUpdate();
		this.entityManager.getTransaction().commit();
	}
}
