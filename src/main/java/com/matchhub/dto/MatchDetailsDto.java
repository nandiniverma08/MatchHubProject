package com.matchhub.dto;

import java.util.List;

import lombok.Data;

@Data
public class MatchDetailsDto {

	private String venue;
	private String playerOfMatch;
	private List<TeamDetailsDto> teams;


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
	public List<TeamDetailsDto> getTeams() {
		return teams;
	}
	public void setTeams(List<TeamDetailsDto> teams) {
		this.teams = teams;
	}






}
