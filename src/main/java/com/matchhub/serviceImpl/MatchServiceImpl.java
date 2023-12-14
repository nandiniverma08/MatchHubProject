package com.matchhub.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matchhub.dto.MatchDetailsDto;
import com.matchhub.dto.TeamDetailsDto;
import com.matchhub.dto.TeamDetailsWinLossDto;
import com.matchhub.entities.Match;
import com.matchhub.entities.Team;
import com.matchhub.entities.TeamDetails;
import com.matchhub.repository.MatchRepository;
import com.matchhub.repository.TeamDetailsRepository;
import com.matchhub.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	private MatchRepository matchRepository;

    @Autowired
    private TeamDetailsRepository teamDetailsRepository;

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

	@Override
	public Match getMatchById(int matchId) {
		return matchRepository.findById(matchId).orElse(null);
	}

	@Override
	public Match updateMatchDetails(Match match) {		
		return matchRepository.save(match);
	}

	@Override
	public TeamDetailsWinLossDto getTeamDetailsWinLossByTeamId(int teamId) {
		Optional<TeamDetails> teamDetailsOptional = teamDetailsRepository.findByTeam_TeamId(teamId);

		if (teamDetailsOptional.isPresent()) {
			TeamDetails teamDetails = teamDetailsOptional.get();

			int totalWins = teamDetails.getTotalWin();
			int totalLosses = teamDetails.getTotalLoss();

			return new TeamDetailsWinLossDto(totalWins, totalLosses);
		} else {
			return null;
		}
	}


}
