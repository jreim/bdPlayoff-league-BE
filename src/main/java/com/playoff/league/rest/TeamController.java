package com.playoff.league.rest;

import com.playoff.league.data.DraftPick;
import com.playoff.league.data.Player;
import com.playoff.league.data.Team;
import com.playoff.league.data.TeamScoreView;
import com.playoff.league.service.DraftPickService;
import com.playoff.league.service.PlayerService;
import com.playoff.league.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

	Logger log = LoggerFactory.getLogger(TeamController.class);
	@Autowired
	private TeamService teamService;
	@Autowired
	private DraftPickService draftPickService;
	@Autowired
	private PlayerService playerService;
	@PostMapping
	private Team persistTeam(@RequestBody Team t)throws Exception{

		if(this.draftPickService.isDraftStarted()) {
			throw new Exception("Draft started. ");
		}
		teamService.persistTeam(t);
		return t;
	}

	@PostMapping("/s")
	private Team persistTeam(@RequestBody List<Team> t)throws Exception{

		if(this.draftPickService.isDraftStarted()) {
			throw new Exception("Draft started. ");
		}
		for(Team tt: t){
			teamService.persistTeam(tt);
		}

		return null;
	}

	@PutMapping
	private Team updateTeam(@RequestBody Team t){
		teamService.persistTeam(t);
		return t;
	}

	@DeleteMapping(path = "/{id}")
	private void DeleteTea(@PathVariable Long id){
		teamService.deleteTeam(id);
	}

	@GetMapping
	public List<Team> getAllTeams(){
		return this.teamService.getAllTeams();
	}

	@GetMapping("/cleanTeams")
	public void cleanTeams(){
		List<Team> teams =  this.teamService.getAllTeams();
		List<DraftPick> picks = this.draftPickService.getAllPicks();
		List<Player> players = this.playerService.findAllPlayers();
		HashMap<Long,Player> playersById = new HashMap<>();
		for(Player p : players){
			playersById.put(p.getId(),p);
		}
		for(Team team: teams){
			team.setPlayers(new ArrayList<>());
			for(DraftPick pick:picks){
				if(pick.getTeamId().equals(team.getId())){
					List<Player> a = team.getPlayers();
					for(Player p :players){
						if(p.getId().equals( pick.getPlayerId())){
							a.add(p);
						}
					}

					team.setPlayers(a);
					this.teamService.persistTeam(team);
				}
			}

		}
	}
	@GetMapping("/picksPer/{teamId}")
	public String cleanTeam(@PathVariable Long teamId) throws Exception{
		List<DraftPick> picks = this.draftPickService.getAllPicks();
		List<Player> players = this.playerService.findAllPlayers();
		List<Player> data = new ArrayList<>();

		StringBuffer sb = new StringBuffer();
		sb.append(" siz of picks" + picks.size()+" sizeof players " + players.size()+"\n");
		for(DraftPick pick:picks){
			sb.append((pick.getTeamId().equals(teamId)) +" pick.getTeamId() " +pick.getTeamId()+" tramID"+teamId +"\n");
			if(pick.getTeamId() == teamId){
				sb.append("matched team id wotu pic " + pick.getId() + " pikc player " + pick.getPlayerId());
				for(Player p :players){
					if(p.getId() == pick.getPlayerId()){
						data.add(p);
//						return data;
					}
				}

			}
		}
		return sb.toString();
//throw new Exception("nothing");
//		return data;

	}



	@GetMapping("/scoreView")
	public List<TeamScoreView> getAllTeamsScoreViews(){
		try{
			return this.teamService.getAllTeamsScoreView();
		}
		catch(Exception e){
			log.error("in all teams" + e.getMessage(),e);
			throw e;
		}


	}

//	@GetMapping(path = "/clearPlayers")
//	public void clearPlayers(){
//		this.teamService.clearPlayers();
//	}
//
	@GetMapping("/shuffle")
	public List<Team> randoDraft(){
		return this.teamService.randoDraft();
	}


}
