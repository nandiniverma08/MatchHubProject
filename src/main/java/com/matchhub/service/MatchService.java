package com.matchhub.service;

import java.util.Date;
import java.util.List;

import com.matchhub.dto.MatchDetailsDto;
import com.matchhub.entities.Match;

public interface MatchService {

	Match addMatch(Match match);

	List<Match> getMatchesByDate(Date matchDate);

	MatchDetailsDto getMatchDetailsById(int matchId);



	Match getMatchById(int matchId);

	Match updateMatchDetails(Match existingMatch);

	

	

}
