package com.matchhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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



}
