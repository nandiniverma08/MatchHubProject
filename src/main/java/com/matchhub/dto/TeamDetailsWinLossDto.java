package com.matchhub.dto;

import lombok.Data;

@Data
public class TeamDetailsWinLossDto {

	private int totalWin;
	private int totalLosse;



	public TeamDetailsWinLossDto(int totalWin, int totalLosse) {
		super();
		this.totalWin = totalWin;
		this.totalLosse = totalLosse;
	}


	public int getTotalWin() {
		return totalWin;
	}
	public void setTotalWin(int totalWin) {
		this.totalWin = totalWin;
	}
	public int getTotalLosse() {
		return totalLosse;
	}
	public void setTotalLosse(int totalLosse) {
		this.totalLosse = totalLosse;
	}




}
