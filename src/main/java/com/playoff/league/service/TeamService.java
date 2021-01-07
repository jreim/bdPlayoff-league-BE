package com.playoff.league.service;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Ref;
import com.playoff.league.data.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class TeamService {

	@Autowired
	private PlayerService playerService;

	private static final Logger log = LoggerFactory.getLogger(TeamService.class);

	public void persistTeam(Team team) {
		ObjectifyService.ofy().save().entities(team).now();
	}

	public Team findTeamById(Long id) {
		Key<Team> teamKey = Key.create(Team.class, id);
		return ObjectifyService.ofy().load().key(teamKey).now();
	}

	public void deleteTeam(Long id) {
		Team team = this.findTeamById(id);
		ObjectifyService.ofy().delete().entity(team).now();

	}

	public List<Team> getAllTeams() {
		return ObjectifyService.ofy().load().type(Team.class).list();
	}

	public List<Team> randoDraft() {
		List<Team> data = this.getAllTeams();
		Collections.shuffle(data);
		int i = 1;
		for (Team t : data) {
			t.setDraftPos(i);
			i++;
			this.persistTeam(t);
		}
		return data;
	}

	public void clearPlayers() {
		List<Team> teams = this.getAllTeams();
		for (Team t : teams) {
			t.setPlayers(new ArrayList<>());
			this.persistTeam(t);
		}
	}

	public void updatePlayersScore(PlayerStat ps) {
		if (ps.getPlayer() == null) {
			log.error("player stat did not have a player. da fuq man. ");
			return;
		}
		List<Team> teams = this.getTeamFromPlayer(ps.getPlayer().get());
		for (Team t : teams) {
			this.updatePlayer(t, ps);
			t.setScore(0);
		}
	}


	private void updatePlayer(Team t, PlayerStat ps) {
		Ref<PlayerStat> statRef = Ref.create(Key.create(PlayerStat.class, ps.getId()));
		for (Player p : t.getPlayers()) {
			if (ps.getPlayer().get().getId().equals(p.getId())) {
				if (PlayoffRound.wildCard.equals(ps.getPlayoffRound())) {
					p.setWcw(statRef);
				}
				if (PlayoffRound.divisional.equals(ps.getPlayoffRound())) {
					p.setDiv(statRef);

				}
				if (PlayoffRound.champion.equals(ps.getPlayoffRound())) {
					p.setChamp(statRef);

				}
				if (PlayoffRound.superbowl.equals(ps.getPlayoffRound())) {
					p.setSb(statRef);

				}
				p.setEliminated(ps.getElim());
				this.playerService.persistPlayer(p);

			}
		}
		this.persistTeam(t);


	}

	private List<Team> getTeamFromPlayer(Player p) {
		ArrayList teams = new ArrayList<>();
		Team t1 = this.teamFromRef(p.getTeam1());
		Team t2 = this.teamFromRef(p.getTeam2());
		if (t1 != null) {
			teams.add(t1);
		}
		if (t2 != null) {
			teams.add(t1);
		}
		return teams;

	}

	private Team teamFromRef(Ref<Team> t1Ref) {

		if (t1Ref == null) {
			return null;
		}
		return t1Ref.get();
	}

	public List<TeamScoreView> getAllTeamsScoreView() {
		List<Team> teams = this.getAllTeams();
		List<Player> players = this.playerService.findAllPlayers();
		List<TeamScoreView> tsv = new ArrayList<>();
		for (Team t : teams) {
			this.updatePlayersForTeam(t,players);
			tsv.add(new TeamScoreView(t));
		}
		return tsv;
	}

	public void updatePlayersForTeam(Team t,List<Player> players ){
		List<Player> pp = new ArrayList<>();

		for(Player p : players){
			for(Player pc: t.getPlayers()){
				if(pc.getId().equals( p.getId())){
					pp.add(p);
				}
			}
		}
		t.setPlayers(pp);
	}
}
