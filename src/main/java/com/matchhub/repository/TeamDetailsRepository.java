package com.matchhub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matchhub.entities.TeamDetails;

public interface TeamDetailsRepository extends JpaRepository<TeamDetails, Integer> {

	 Optional<TeamDetails> findByTeam_TeamId(int teamId);

}
