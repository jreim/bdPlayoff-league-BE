package com.playoff.league.service;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.playoff.league.data.NFLTeam;
import com.playoff.league.data.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerService {


	private static final Logger log = LoggerFactory.getLogger(PlayerService.class);
	public void persistPlayer(Player player){
      ObjectifyService.ofy().save().entities(player).now();
	}

	public Player findPlayerById(Long playerId) {
		Key<Player> playerKey = Key.create(Player.class,playerId);
		return ObjectifyService.ofy().load().key(playerKey).now();
	}

	public List<Player> findPlayersByTeam(NFLTeam team){
		List<Player> playersIter = ObjectifyService.ofy().load().type(Player.class).filterKey("nflTeam" , team).list();
		log.error(Integer.toString(playersIter.size()));
		return playersIter;
	}

	public void deletePlayerById(Long playerId){
		Key<Player> playerKey = Key.create(Player.class,playerId);
		ObjectifyService.ofy().delete().key(playerKey).now();
	}

	public void clearTeams(){
		List<Player> players = this.findAllPlayers();
		for(Player p: players){
			this.cleanTeam(p);
		}
	}
	public void clearTeam(Long id){
		Player p = this.findPlayerById(id);
		this.cleanTeam(p);
	}

	private void cleanTeam(Player p ){

		p.setTeam1(null);
		p.setTeam2(null);
		this.persistPlayer(p);
	}

	public List<Player> findAllPlayers() {
		return ObjectifyService.ofy().load().type(Player.class).list();
	}

	public List<Player> findAllPlayersByTeam(NFLTeam team){
		return ObjectifyService.ofy().load().type(Player.class).filter("nflTeam",team).list();
	}
}
