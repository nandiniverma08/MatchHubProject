package com.matchhub.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team_details_table")
public class TeamDetails {

	@Id
	@Column(name = "team_details_id")
	private int teamDetailsId;

	@Column(name = "captain")
	private String captain;

	@Column(name = "number_of_players")
	private int numberOfPlayers;

	@Column(name = "batsman")
	private String batsman;

	@Column(name = "bowler")
	private String bowler;

	@Column(name = "team_rank")
	private int teamRank;

	@OneToOne
	@JoinColumn(name = "team_id")
	private Team team;

	public TeamDetails() {

	}

	public int getTeamDetailsId() {
		return teamDetailsId;
	}

	public void setTeamDetailsId(int teamDetailsId) {
		this.teamDetailsId = teamDetailsId;
	}

	public String getCaptain() {
		return captain;
	}

	public void setCaptain(String captain) {
		this.captain = captain;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public String getBatsman() {
		return batsman;
	}

	public void setBatsman(String batsman) {
		this.batsman = batsman;
	}

	public String getBowler() {
		return bowler;
	}

	public void setBowler(String bowler) {
		this.bowler = bowler;
	}

	public int getTeamRank() {
		return teamRank;
	}

	public void setTeamRank(int teamRank) {
		this.teamRank = teamRank;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public TeamDetails(int teamDetailsId, String captain, int numberOfPlayers, String batsman, String bowler,
			int teamRank, Team team) {
		super();
		this.teamDetailsId = teamDetailsId;
		this.captain = captain;
		this.numberOfPlayers = numberOfPlayers;
		this.batsman = batsman;
		this.bowler = bowler;
		this.teamRank = teamRank;
		this.team = team;
	}

	@Override
	public String toString() {
		return "TeamDetails [teamDetailsId=" + teamDetailsId + ", captain=" + captain + ", numberOfPlayers="
				+ numberOfPlayers + ", batsman=" + batsman + ", bowler=" + bowler + ", teamRank=" + teamRank + ", team="
				+ team + "]";
	}

}
