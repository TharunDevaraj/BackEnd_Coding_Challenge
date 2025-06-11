package com.hexaware.cricketteammanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cricketteammanagementsystem.entity.Player;
import com.hexaware.cricketteammanagementsystem.exception.InvalidRoleException;
import com.hexaware.cricketteammanagementsystem.exception.PlayerNotFoundException;
import com.hexaware.cricketteammanagementsystem.repository.PlayerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlayerServiceImp implements IPlayerService{

	@Autowired
	PlayerRepository playerRepository;
	
	@Override
	public List<Player> getAllPlayers() {
		
		return playerRepository.findAll();
	}

	@Override
	public Player getPlayerById(int playerId) {
		
		return playerRepository.findById(playerId).orElse(null);
	}

	@Override
	public Player addPlayer(Player player) throws InvalidRoleException {
		if(!validatePlayerDetails(player.getRole()))
		{
			throw new InvalidRoleException();
		}
		
		return playerRepository.save(player);
	}

	@Override
	public Player updatePlayerById(int playerId, Player player) throws PlayerNotFoundException{
		
		Player updatePlayer = playerRepository.findById(playerId).orElse(null);
		if(updatePlayer==null)
		{
			throw new PlayerNotFoundException();
		}
		if (player.getPlayerName() != null && !player.getPlayerName().isEmpty())
		    updatePlayer.setPlayerName(player.getPlayerName());

		if (player.getJerseyNumber() > 0)
		    updatePlayer.setJerseyNumber(player.getJerseyNumber());

		if (player.getRole() != null && !player.getRole().isEmpty())
		    updatePlayer.setRole(player.getRole());

		if (player.getTotalMatches() >= 0)
		    updatePlayer.setTotalMatches(player.getTotalMatches());

		if (player.getTeamName() != null && !player.getTeamName().isEmpty())
		    updatePlayer.setTeamName(player.getTeamName());

		if (player.getCountry() != null && !player.getCountry().isEmpty())
		    updatePlayer.setCountry(player.getCountry());

		if (player.getDescription() != null && !player.getDescription().isEmpty())
		    updatePlayer.setDescription(player.getDescription());
		return playerRepository.save(updatePlayer);
	}

	@Override
	public void deletePlayerById(int playerId) throws PlayerNotFoundException {
		
		Player deletePlayer = playerRepository.findById(playerId).orElse(null);
		if(deletePlayer==null)
		{
			throw new PlayerNotFoundException();
		}
		playerRepository.deleteById(playerId);
		
	}
	
	public boolean validatePlayerDetails(String role)
	{
		if(role.equalsIgnoreCase("Batsman")||role.equalsIgnoreCase("Bowler")||role.equalsIgnoreCase("Wicket Keeper")||role.equalsIgnoreCase("All Rounder"))
			return true;
		return false;
	}

	//delete player records by teamName
	@Override
	public int deletePlayersByTeam(String teamName) {
		
		
		return playerRepository.deleteByTeamName(teamName);
	}

	@Override
	public List<Player> getPlayerByTeam(String teamName) {
		
		return playerRepository.findByTeamName(teamName).orElse(null);
	}
	
	

}
