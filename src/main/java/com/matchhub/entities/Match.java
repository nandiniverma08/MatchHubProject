package com.matchhub.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cricket_table")
public class Match {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "match_id")
    private int matchId;

    @Column(name = "teamA")
    private String teamA;

    @Column(name = "teamB")
    private String teamB;

    @Column(name = "venue")
    private String venue;

    @Column(name = "player_of_match")
    private String playerOfMatch;

    @Column(name = "result_win")
    private String resultWin;

    @Column(name = "win_by_runs")
    private String winByRuns;
    
    @Column(name = "match_date")
    private Date date;


  
 

    public Date getDate() {
		return date;
	}




	public void setDate(Date date) {
		this.date = date;
	}




	public Match() {

    }




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getMatchId() {
		return matchId;
	}




	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}




	public String getTeamA() {
		return teamA;
	}




	public void setTeamA(String teamA) {
		this.teamA = teamA;
	}




	public String getTeamB() {
		return teamB;
	}




	public void setTeamB(String teamB) {
		this.teamB = teamB;
	}




	public String getVenue() {
		return venue;
	}




	public void setVenue(String venue) {
		this.venue = venue;
	}




	public String getPlayerOfMatch() {
		return playerOfMatch;
	}




	public void setPlayerOfMatch(String playerOfMatch) {
		this.playerOfMatch = playerOfMatch;
	}




	public String getResultWin() {
		return resultWin;
	}




	public void setResultWin(String resultWin) {
		this.resultWin = resultWin;
	}




	public String getWinByRuns() {
		return winByRuns;
	}




	public void setWinByRuns(String winByRuns) {
		this.winByRuns = winByRuns;
	}




	public Match(int id, int matchId, String teamA, String teamB, String venue, String playerOfMatch, String resultWin,
			String winByRuns, Date date) {
		super();
		this.id = id;
		this.matchId = matchId;
		this.teamA = teamA;
		this.teamB = teamB;
		this.venue = venue;
		this.playerOfMatch = playerOfMatch;
		this.resultWin = resultWin;
		this.winByRuns = winByRuns;
		this.date = date;
	}




	@Override
	public String toString() {
		return "Match [date=" + date + "]";
	}
    
    


	


}


