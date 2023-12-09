package com.matchhub.entities;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "team_details")
public class TeamsDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "players")
    private String[] players;

    @Column(name = "number_of_wins")
    private int numberOfWins;

    @Column(name = "number_of_losses")
    private int numberOfLosses;

    @ManyToOne(fetch = FetchType.LAZY,optional=false)
    @JoinColumn(name = "match_id") 
    private Match match;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String[] getPlayers() {
		return players;
	}

	public void setPlayers(String[] players) {
		this.players = players;
	}

	public int getNumberOfWins() {
		return numberOfWins;
	}

	public void setNumberOfWins(int numberOfWins) {
		this.numberOfWins = numberOfWins;
	}

	public int getNumberOfLosses() {
		return numberOfLosses;
	}

	public void setNumberOfLosses(int numberOfLosses) {
		this.numberOfLosses = numberOfLosses;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	@Override
	public String toString() {
		return "TeamsDetails [id=" + id + ", teamName=" + teamName + ", players=" + Arrays.toString(players)
				+ ", numberOfWins=" + numberOfWins + ", numberOfLosses=" + numberOfLosses + ", match=" + match + "]";
	}

	public TeamsDetails(int id, String teamName, String[] players, int numberOfWins, int numberOfLosses, Match match) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.players = players;
		this.numberOfWins = numberOfWins;
		this.numberOfLosses = numberOfLosses;
		this.match = match;
	}

    
    
}
