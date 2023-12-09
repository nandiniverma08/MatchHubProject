package com.matchhub.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matchhub.entities.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
	
	List<Match> findByDate(Date matchDate);


}
