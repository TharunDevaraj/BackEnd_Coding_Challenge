package com.hexaware.cricketteammanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexaware.cricketteammanagementsystem.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{
	
	//delete player records by teamName
	@Modifying
	@Query(nativeQuery = true, value = "delete from player where team_name = :teamName")
	public int deleteByTeamName(@Param("teamName") String teamName);

}
