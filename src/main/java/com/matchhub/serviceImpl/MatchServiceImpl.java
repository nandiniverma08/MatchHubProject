package com.matchhub.serviceImpl;

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




}
