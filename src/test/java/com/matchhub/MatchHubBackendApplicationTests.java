package com.matchhub;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.matchhub.entities.Match;
import com.matchhub.entities.Team;
import com.matchhub.entities.TeamDetails;
import com.matchhub.repository.MatchRepository;

@SpringBootTest
class MatchHubBackendApplicationTests {

	
	@Autowired
	private MatchRepository matchRepository;
	
	
	@Test
	public void testCreate() {
		Match match = new Match();
        match.setId(106);
        match.setVenue("Test Venue");
        match.setDate(new Date());
        match.setPlayerOfMatch("Sample Player");
        match.setResultWin("Sample Result");
        match.setWinByRuns("10 runs");  // Assuming winByRuns is a String in your entity
        // Set other necessary fields...
        
        
     // Create a Team object with sample data
        Team team = new Team();
        team.setTeamId(134);
        team.setTeamName("Sample Team");
        team.setMatch(match);
        
        
        // Create a TeamDetails object with sample data
        TeamDetails teamDetails = new TeamDetails();
        teamDetails.setTeamDetailsId(140);
        teamDetails.setCaptain("Captain Name");
        teamDetails.setNumberOfPlayers(11);
        teamDetails.setBatsman("Sample Batsman");
        teamDetails.setBowler("Sample Bowler");
        teamDetails.setTeamRank(1);
        teamDetails.setTotalWin(5);
        teamDetails.setTotalLoss(2);
        
        team.setTeamDetails(teamDetails);
        match.setTeams(Collections.singletonList(team));
        
        
        Match savedMatch = matchRepository.save(match);
        assertNotNull(matchRepository.findById(106).get());
	}
	
	
	@Test
	public void testReadAll() {
		List<Match> list = matchRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	
	@Test
	public void testSingleMatchById() {
		Match match = matchRepository.findById(105).get();
		assertEquals("MCG", match.getVenue());
	}
	
	
	@Test
	public void testUpdate() {
		Match match2 = matchRepository.findById(105).get();
		match2.setWinByRuns("20");
		matchRepository.save(match2);
		assertNotEquals("12", matchRepository.findById(105).get().getWinByRuns());
	}
	
	
	
}
