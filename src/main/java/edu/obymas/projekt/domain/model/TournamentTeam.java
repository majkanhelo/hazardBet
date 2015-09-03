package edu.obymas.projekt.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

@Entity 
@IdClass(TournamentTeamId.class)
@Table(name = "Tournaments_has_Teams")
@Transactional 
public class TournamentTeam {
	
	@Id
	@Column(name = "Team_Id")
	private long teamId;
	
	@Id
    @Column(name="Tournament_Id")
	private long tournamentId;	
	
	public TournamentTeam() {
		super();
	}

	public long getTeamId() {
		return teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public long getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(long tournamentId) {
		this.tournamentId = tournamentId;
	}
	
}
