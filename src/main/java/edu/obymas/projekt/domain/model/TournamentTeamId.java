package edu.obymas.projekt.domain.model;

import java.io.Serializable;

import javax.persistence.Column;

public class TournamentTeamId implements Serializable{
	
	private long teamId;
	private long tournamentId;	
	
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

	@Override
    public int hashCode(){        
        return this.hashCode();
    }

    @Override
    public boolean equals(Object o){
        boolean flag = false;
        TournamentTeamId myId = (TournamentTeamId) o;

        if( (o instanceof TournamentTeamId) 
                && (this.getTeamId()==myId.getTeamId())
                && (this.getTournamentId() == myId.getTournamentId())){
            flag = true;
        }
        return flag;
    }
}
