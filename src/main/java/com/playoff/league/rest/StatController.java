package com.playoff.league.rest;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Ref;
import com.playoff.league.data.*;
import com.playoff.league.service.DraftPickService;
import com.playoff.league.service.PlayerService;
import com.playoff.league.service.StatService;
import com.playoff.league.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stat")
public class StatController {

	@Autowired
	private StatService statService;
	@Autowired
	private PlayerService playerService;
	@Autowired
	private TeamService	teamService;

	@PostMapping(path = "/player/{playerId}")
	public PlayerStat processPlayerStat(@RequestBody PlayerStat ps, @PathVariable Long playerId){

		Player p = playerService.findPlayerById(playerId);
		int score = ps.getScore();
		ps.setPlayer(Ref.create(Key.create(Player.class,playerId)));
		if(ps.getId().equals(0L)){
			ps.setId(null);
		}

		this.statService.persistPick(ps);
		this.teamService.updatePlayersScore(ps);
		return ps;
	}



}
