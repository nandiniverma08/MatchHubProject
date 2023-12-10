package com.matchhub.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matchhub.dto.MatchDetailsDto;
import com.matchhub.dto.TeamDetailsDto;
import com.matchhub.entities.Match;
import com.matchhub.entities.Team;
import com.matchhub.entities.TeamDetails;
import com.matchhub.repository.MatchRepository;
import com.matchhub.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {

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

	@Override
	public MatchDetailsDto getMatchDetailsById(int matchId) {
		Match match = matchRepository.findById(matchId)
				.orElseThrow(() -> new RuntimeException("Match not found with ID: " + matchId));

		return convertToMatchDetailsDto(match);
	}

	private MatchDetailsDto convertToMatchDetailsDto(Match match) {

		MatchDetailsDto matchDetailsDto = new MatchDetailsDto();
		matchDetailsDto.setVenue(match.getVenue());
		matchDetailsDto.setPlayerOfMatch(match.getPlayerOfMatch());

		List<TeamDetailsDto> teamDetailsDtos = new ArrayList<>();

		for (Team team : match.getTeams()) {

			TeamDetailsDto teamDetailsDto = new TeamDetailsDto();
			teamDetailsDto.setTeamId(team.getTeamId());
			teamDetailsDto.setTeamName(team.getTeamName());

			TeamDetails teamDetails = team.getTeamDetails();
			teamDetailsDto.setCaptain(teamDetails.getCaptain());
			teamDetailsDto.setNumberOfPlayers(teamDetails.getNumberOfPlayers());
			teamDetailsDto.setBatsman(teamDetails.getBatsman());
			teamDetailsDto.setBowler(teamDetails.getBowler());
			teamDetailsDto.setTeamRank(teamDetails.getTeamRank());

			teamDetailsDtos.add(teamDetailsDto);
		}

		matchDetailsDto.setTeams(teamDetailsDtos);

		return matchDetailsDto;

	}
//
//	@Override
//	public ResponseEntity<Match> updateMatchDetails(int matchId, Match updatedMatch) {
//		Match existingMatch = matchRepository.findById(matchId)
//				.orElseThrow(() -> new RuntimeException("Match not found with ID: " + matchId));
//
//		// Update the fields
//		existingMatch.setPlayerOfMatch(updatedMatch.getPlayerOfMatch());
//		existingMatch.setResultWin(updatedMatch.getResultWin());
//
//		// Save the updated match
//		matchRepository.save(existingMatch);
//
//		return new ResponseEntity<>(existingMatch, HttpStatus.OK);
//	}

	@Override
	public Match getMatchById(int matchId) {
	    return matchRepository.findById(matchId).orElse(null);
	}


	 @Override
	    public Match updateMatchDetails(Match match) {
	        // You might want to add some validation or business logic here before updating
	        return matchRepository.save(match);
	    }

}
