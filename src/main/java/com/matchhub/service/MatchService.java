package com.matchhub.service;

import java.util.Date;
import java.util.List;

import com.matchhub.entities.Match;

public interface MatchService {

	Match addMatch(Match match);

	List<Match> getMatchesByDate(Date matchDate);

	

	

}
