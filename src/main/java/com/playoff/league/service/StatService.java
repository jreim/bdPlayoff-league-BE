package com.playoff.league.service;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.playoff.league.data.DraftPick;
import com.playoff.league.data.PlayerStat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StatService {


	private static final Logger log = LoggerFactory.getLogger(StatService.class);
	public void persistPick(PlayerStat stat){
      ObjectifyService.ofy().save().entities(stat).now();
	}

//	public DraftPick findPlayerById(Long playerId) {
//		Key<Player> playerKey = Key.create(DraftPick.class,playerId);
//		return ObjectifyService.ofy().load().key(playerKey).now();
//	}

//	public List<DraftPick> findPlayersByTeam(NFLTeam team){
//		List<Player> playersIter = ObjectifyService.ofy().load().type(Player.class).filterKey("nflTeam" , team).list();
//		log.error(Integer.toString(playersIter.size()));
//		return playersIter;
//	}
//
//	public void deletePlayerById(Long playerId){
//		Key<Player> playerKey = Key.create(Player.class,playerId);
//		ObjectifyService.ofy().delete().key(playerKey).now();
//	}
//
//	public List<DraftPick> getAllPicks() {
//		List<DraftPick> picks;
//		picks=  ObjectifyService.ofy().load().type(DraftPick.class).list();
//		return picks == null? new ArrayList<>(): picks;
//	}
//
//	public void deleteAllPicks() {
//		List<DraftPick> dpList = this.getAllPicks();
//		for(DraftPick dp :dpList){
//			Key dpKey = Key.create(DraftPick.class,dp.getId());
//			ObjectifyService.ofy().delete().key(dpKey);
//		}
//
//	}
//
//	public DraftPick findPickById(Long pickId) {
//		Key<DraftPick> dpKey = Key.create(DraftPick.class,pickId);
//		return  ObjectifyService.ofy().load().key(dpKey).now();
//	}
}
