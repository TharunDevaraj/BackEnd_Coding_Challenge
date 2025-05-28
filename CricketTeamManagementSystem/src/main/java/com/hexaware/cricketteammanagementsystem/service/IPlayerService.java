package com.hexaware.cricketteammanagementsystem.service;

import java.util.List;

import com.hexaware.cricketteammanagementsystem.entity.Player;
import com.hexaware.cricketteammanagementsystem.exception.InvalidRoleException;
import com.hexaware.cricketteammanagementsystem.exception.PlayerNotFoundException;

public interface IPlayerService {
	
	public List<Player> getAllPlayers();
	
	public Player getPlayerById(int playerId);
	
	public Player addPlayer(Player player) throws InvalidRoleException;
	
	public Player updatePlayerById(int playerId,Player player) throws PlayerNotFoundException;
	
	public void deletePlayerById(int playerId) throws PlayerNotFoundException;
	
	//delete player records by teamName
	public int deletePlayersByTeam(String teamName);

}
