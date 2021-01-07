package com.playoff.league.service;

import com.googlecode.objectify.ObjectifyService;
import com.playoff.league.data.DraftPick;
import com.playoff.league.data.Game;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameService {

	public void persistPlayer(Game game){
      ObjectifyService.ofy().save().entities(game).now();
	}

	public List<Game> getAllGames() {
		List<Game> games;
		games=  ObjectifyService.ofy().load().type(Game.class).list();
		return games == null? new ArrayList<>(): games;
	}
//
//	public Player findPlayerById(Long playerId) {
//		Key<Player> playerKey = Key.create(Player.class,playerId);
//		return ObjectifyService.ofy().load().key(playerKey).now();
//	}
//
//	public List<Player> findPlayersByTeam(NFLTeam team){
//		List<Player> playersIter = ObjectifyService.ofy().load().type(Player.class).filterKey("nflTeam" , team).list();
//		log.error(Integer.toString(playersIter.size()));
//		return playersIter;
//	}
//
//	public void deletePlayerById(Long playerId){
//		Key<Player> playerKey = Key.create(Player.class,playerId);
//		ObjectifyService.ofy().delete().key(playerKey).now();
//	}


}
