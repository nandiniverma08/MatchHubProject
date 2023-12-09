package com.matchhub.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matchhub.entities.Match;
import com.matchhub.service.MatchService;

@RestController
public class MatchController {

	@Autowired
	private MatchService matchService;

	@PostMapping("/addMatch")
	public Match addMatch(@RequestBody Match match) {
		return matchService.addMatch(match);
	}

	@GetMapping("/listMatchesByDate")
	public List<Match> getMatchesByDate(@RequestParam("matchDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date matchDate) {
	    return matchService.getMatchesByDate(matchDate);
	}



}
