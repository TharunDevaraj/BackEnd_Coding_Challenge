package com.hexaware.cricketteammanagementsystem.dto;

public class PlayerResponseDTO {
	
	private int playerId;
	private String playerName;
	private int jerseyNumber;
	private String role;
	
	public PlayerResponseDTO()
	{
		
	}

	public PlayerResponseDTO(int playerId, String playerName, int jerseyNumber, String role) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.jerseyNumber = jerseyNumber;
		this.role = role;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getJerseyNumber() {
		return jerseyNumber;
	}

	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
