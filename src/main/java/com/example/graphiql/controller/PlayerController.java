package com.example.graphiql.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.graphiql.model.Player;
import com.example.graphiql.service.PlayerService;

@Controller
public class PlayerController {
	
	private final PlayerService playerService;

	public PlayerController(PlayerService playerService) {
		super();
		this.playerService = playerService;
	}
	
	@QueryMapping
	public List<Player> findAll(){
		return playerService.findAll();
	}
	
}
