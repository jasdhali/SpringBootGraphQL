package com.example.graphiql.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.example.graphiql.model.Player;
import com.example.graphiql.model.Team;

import jakarta.annotation.PostConstruct;

@Service
public class PlayerService {
	private List<Player> players = new ArrayList<>();
	AtomicInteger integer = new AtomicInteger();
	@PostConstruct
	public void init(){
		players.add(new Player(1, "ram", Team.CSK));
		players.add(new Player(2, "shyam", Team.GT));
		players.add(new Player(3, "hari", Team.MI));
		players.add(new Player(4, "mohan", Team.CSK));
		
	}
	public List<Player> findAll(){
		return players;
	}
	
	public Optional<Player> findOne(Integer id) {
		return players.stream().filter(player -> player.id() == id).findFirst();
	}
	
	public Player create(String name,Team team) {
		Player player = new Player(integer.incrementAndGet(), name, team);
		players.add(player);
		return player;
	}
	
	public Player delete(Integer id) {
		Optional<Player> optional =  findOne( id);
		Player playerDeleted = optional.get(); 
		players.remove( playerDeleted );
		return playerDeleted;
	}
	public Player update(Integer id,String name,Team team) {
		Optional<Player> optional =  findOne(id);
		Player playerToUpdate = optional.get();
		
		Player playerNew = new Player(id, name, team);
		int index = players.indexOf(playerToUpdate);
		
		players.set(index, playerToUpdate);
		return playerToUpdate;
	}
}
