package com.hexaware.cricketteammanagementsystem.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cricketteammanagementsystem.dto.PlayerResponseDTO;
import com.hexaware.cricketteammanagementsystem.entity.Player;
import com.hexaware.cricketteammanagementsystem.exception.InvalidRoleException;
import com.hexaware.cricketteammanagementsystem.exception.PlayerNotFoundException;
import com.hexaware.cricketteammanagementsystem.service.IPlayerService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/players")
public class PlayerRestController {
	
	@Autowired
	IPlayerService playerService;
	
	@GetMapping("/")
	public List<Player> getAllPlayers()
	{
		return playerService.getAllPlayers();
		
	}
	
	@GetMapping("/{playerId}")
	public PlayerResponseDTO getPlayerById(@PathVariable int playerId)
	{
		Player player = playerService.getPlayerById(playerId);
		
		if(player!=null)
		{
			return EntityToDTO(player);
		}
		return null;
		
	}
	
	@GetMapping("/team/{teamName}")
	public List<PlayerResponseDTO> getPlayerByTeam(@PathVariable String teamName)
	{
		List<Player> players = playerService.getPlayerByTeam(teamName);
		
		List<PlayerResponseDTO> playerDTOs=new ArrayList<>();
		
		if(players==null)
		{
			return null;
		}
		for(Player player:players)
		{
			playerDTOs.add(EntityToDTO(player));
		}
		return playerDTOs;
		
	}
	
	@PostMapping("/")
	public PlayerResponseDTO addPlayer(@Valid @RequestBody Player player) throws InvalidRoleException
	{
		Player addedPlayer = playerService.addPlayer(player);
		
		return EntityToDTO(addedPlayer);
	}
	
	@PutMapping("/{playerId}")
	public PlayerResponseDTO updatePlayerById(@PathVariable int playerId, @Valid @RequestBody Player player) throws PlayerNotFoundException
	{
		Player updatedPlayer = playerService.updatePlayerById(playerId, player);
		
		return EntityToDTO(updatedPlayer);
	}
	
	@DeleteMapping("/{playerId}")
	public ResponseEntity<String> deletePlayerById(@PathVariable int playerId) throws PlayerNotFoundException {
	    playerService.deletePlayerById(playerId);
	    return ResponseEntity.ok("Player Removed");
	}

	
	
	//delete player records by teamName
	@DeleteMapping("/team/{teamName}")
	public String deletePlayersByTeam(@PathVariable String teamName)
	{
		int rowsDeleted = playerService.deletePlayersByTeam(teamName);
		
		return "No of player records deleted : "+rowsDeleted;
		
	}
	
	private PlayerResponseDTO EntityToDTO(Player player)
	{
		PlayerResponseDTO dto=new PlayerResponseDTO();
		dto.setPlayerId(player.getPlayerId());
		dto.setPlayerName(player.getPlayerName());
		dto.setJerseyNumber(player.getJerseyNumber());
		dto.setRole(player.getRole());
		dto.setTotalMatches(player.getTotalMatches());
		dto.setTeamName(player.getTeamName());
		dto.setCountry(player.getCountry());
		dto.setDescription(player.getDescription());
		return dto;
	}

}
