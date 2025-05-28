package com.hexaware.cricketteammanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cricketteammanagementsystem.entity.Player;
import com.hexaware.cricketteammanagementsystem.exception.InvalidRoleException;
import com.hexaware.cricketteammanagementsystem.exception.PlayerNotFoundException;
import com.hexaware.cricketteammanagementsystem.repository.PlayerRepository;

@Service
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
		updatePlayer.setPlayerName(player.getPlayerName());
	    updatePlayer.setJerseyNumber(player.getJerseyNumber());
	    updatePlayer.setRole(player.getRole());
	    updatePlayer.setTotalMatches(player.getTotalMatches());
	    updatePlayer.setTeamName(player.getTeamName());
	    updatePlayer.setCountry(player.getCountry());
	    updatePlayer.setDescription(player.getDescription());
		return playerRepository.save(updatePlayer);
	}

	@Override
	public void deletePlayerById(int playerId) {
		
		playerRepository.deleteById(playerId);
		
	}
	
	public boolean validatePlayerDetails(String role)
	{
		if(role.equalsIgnoreCase("Batsman")||role.equalsIgnoreCase("Bowler")||role.equalsIgnoreCase("Wicket Keeper")||role.equalsIgnoreCase("All Rounder"))
			return true;
		return false;
	}

}
