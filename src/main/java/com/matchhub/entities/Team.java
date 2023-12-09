package com.matchhub.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team_table")
public class Team {

	@Id
	@Column(name = "team_id")
	private int teamId;

	@Column(name = "team_name")
	private String teamName;

	@ManyToOne
	@JoinColumn(name = "match_id")
	private Match match;

	@OneToOne(mappedBy = "team" , cascade = CascadeType.ALL)
	private TeamDetails teamDetails;

	public Team() {

	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public TeamDetails getTeamDetails() {
		return teamDetails;
	}

	public void setTeamDetails(TeamDetails teamDetails) {
		this.teamDetails = teamDetails;
	}

	public Team(int teamId, String teamName, Match match, TeamDetails teamDetails) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.match = match;
		this.teamDetails = teamDetails;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", match=" + match + ", teamDetails=" + teamDetails
				+ "]";
	}

	
	

}
