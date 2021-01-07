package com.playoff.league.rest;

import com.playoff.league.data.Game;
import com.playoff.league.data.Team;
import com.playoff.league.service.DraftPickService;
import com.playoff.league.service.GameService;
import com.playoff.league.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

	@Autowired
	private GameService gameService;

	@PostMapping
	public Game postGame(@RequestBody Game game){
		this.gameService.persistPlayer(game);
		return game;
	}

	@GetMapping
	public List<Game> getAll(){
		return this.gameService.getAllGames();
	}

}
