package com.matchhub.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	@Column(name = "id")
	private int id;

	@Column(name = "venue")
	private String venue;

	@Column(name = "match_date")
	private Date date;

	@Column(name = "player_of_match")
	private String playerOfMatch;

	@Column(name = "result_win")
	private String resultWin;

	@Column(name = "win_by_runs")
	private String winByRuns;

	@OneToMany(targetEntity = Team.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "match_id" , referencedColumnName = "id")
	private List<Team> teams;

	
	public Match() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getVenue() {
		return venue;
	}


	public void setVenue(String venue) {
		this.venue = venue;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
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


	public List<Team> getTeams() {
		return teams;
	}


	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	
	
	

	public Match(int id, String venue, Date date, String playerOfMatch, String resultWin, String winByRuns,
			List<Team> teams) {
		super();
		this.id = id;
		this.venue = venue;
		this.date = date;
		this.playerOfMatch = playerOfMatch;
		this.resultWin = resultWin;
		this.winByRuns = winByRuns;
		this.teams = teams;
	}


	@Override
	public String toString() {
		return "Match [id=" + id + ", venue=" + venue + ", date=" + date + ", playerOfMatch=" + playerOfMatch
				+ ", resultWin=" + resultWin + ", winByRuns=" + winByRuns + ", teams=" + teams + "]";
	}
	
	
	
	
	

  
 

	


}


