package com.hexaware.cricketteammanagementsystem.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/players")
public class PlayerRestController {
	
	@Autowired
	IPlayerService playerService;
	
	@GetMapping("/")
	public List<PlayerResponseDTO> getAllPlayers()
	{
		List<Player> players=playerService.getAllPlayers();
		
		List<PlayerResponseDTO> playerDetails = new ArrayList<>();
		
		for(Player player:players)
		{
			playerDetails.add(EntityToDTO(player));
		}
		
		return playerDetails;
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
	public String deletePlayerById(@PathVariable int playerId)
	{
		playerService.deletePlayerById(playerId);
		
		return "Player Removed";
	}
	
	private PlayerResponseDTO EntityToDTO(Player player)
	{
		PlayerResponseDTO dto=new PlayerResponseDTO();
		dto.setPlayerId(player.getPlayerId());
		dto.setPlayerName(player.getPlayerName());
		dto.setJerseyNumber(player.getJerseyNumber());
		dto.setRole(player.getRole());
		return dto;
	}

}
