package com.matchhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matchhub.entities.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
	



}
