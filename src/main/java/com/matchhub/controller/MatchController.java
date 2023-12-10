package com.matchhub.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matchhub.dto.MatchDetailsDto;
import com.matchhub.dto.TeamDetailsWinLossDto;
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
	public List<Match> getMatchesByDate(
			@RequestParam("matchDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date matchDate) {
		return matchService.getMatchesByDate(matchDate);
	}

	@GetMapping("/getMatchDetailsById/{matchId}")
	public MatchDetailsDto getMatchDetailsById(@PathVariable("matchId") int matchId) {
		return matchService.getMatchDetailsById(matchId);
	}

	@PutMapping("/updateMatchDetails/{matchId}")
	public ResponseEntity<Match> updateMatchDetails(@PathVariable("matchId") int matchId,
			@RequestBody Match updatedMatch) {
		Match existingMatch = matchService.getMatchById(matchId);

		if (existingMatch != null) {
			// Update the fields you want to modify
			existingMatch.setPlayerOfMatch(updatedMatch.getPlayerOfMatch());
			existingMatch.setResultWin(updatedMatch.getResultWin());

			// Save the updated match
			Match updated = matchService.updateMatchDetails(existingMatch);

			return new ResponseEntity<>(updated, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getTeamDetails/{teamId}")
	public ResponseEntity<TeamDetailsWinLossDto> getTeamDetails(@PathVariable("teamId") int teamId) {
		TeamDetailsWinLossDto teamDetailsWinLossDto = matchService.getTeamDetailsWinLossByTeamId(teamId);

		if (teamDetailsWinLossDto != null) {
			return new ResponseEntity<>(teamDetailsWinLossDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
