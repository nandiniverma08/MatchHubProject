package com.matchhub.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matchhub.entities.Match;
import com.matchhub.repository.MatchRepository;
import com.matchhub.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService{

	@Autowired
	private MatchRepository matchRepository;

	@Override
	public Match addMatch(Match match) {
		return matchRepository.save(match);

	}


	@Override
	public List<Match> getMatchesByDate(Date matchDate) {
		return matchRepository.findByDate(matchDate);
	}
	
	




}
