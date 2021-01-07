package com.playoff.league.rest;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Ref;
import com.playoff.league.data.DraftPick;
import com.playoff.league.data.NFLTeam;
import com.playoff.league.data.Player;
import com.playoff.league.data.Team;
import com.playoff.league.service.DraftPickService;
import com.playoff.league.service.PlayerService;
import com.playoff.league.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/draft")
public class DraftController {

	@Autowired
	private DraftPickService draftPickService;
	@Autowired
	private TeamService teamService;

	@Autowired
	private PlayerService playerService;
	@GetMapping
	public List<DraftPick> nflTeamStrings(){
		return draftPickService.getAllPicks();
	}

	@DeleteMapping
	public void deleteAllDraftPicks(@RequestParam String key){
		if(key.equals("XXX")){
			draftPickService.deleteAllPicks();
		}

	}
	@GetMapping(path="/currentPick/{pickNumber}")
	public String checkPick(@PathVariable Long pickNumber){
		if(pickNumber <= 0){
			return "";
		}
		List<DraftPick> data = draftPickService.getAllPicks();
		long count=0;
		for(DraftPick d: data){
			if(d.getPlayerId() != 0){
				count+=1;
			}
		}
//		System.out.println("count " + count + " pick number " + pickNumber);
		if(count == pickNumber){
			return "";
		}
		else{
			return "LOAD";
		}
	}



	@GetMapping(path="/start")
	public void startDraft(){
//		if(this.draftPickService.isDraftStarted()){
//			return;
//		}
		ArrayList<Team> teams = this.forceSort(teamService.getAllTeams());
		Collections.sort(teams);

		int pickNumber = 1;
		Team currentTeam = null;
		int round = 1;
		int teamIdx;
		while(round <= 8){

			if(round%2==0){
				teamIdx=teams.size()-1;
				while (teamIdx >= 0){
//						System.out.println(round+"." + pickNumber + " teamIdx: " + teamIdx );
					currentTeam = teams.get(teamIdx);
					this.makePick(currentTeam,round,pickNumber);
					teamIdx--;
					pickNumber++;
				}
			}
			else{
				teamIdx=0;
				while(teamIdx < teams.size()){
//						System.out.println(round+"." + pickNumber + " teamIdx: " + teamIdx );
					currentTeam = teams.get(teamIdx);
					this.makePick(currentTeam,round,pickNumber);
					pickNumber++;
					teamIdx++;
				}
			}
			round++;

		}

	}

	@PutMapping("/pick/{pickId}")
	public void draftPlayer(@RequestParam Long playerId,@PathVariable Long pickId)throws Exception{
		DraftPick dp = draftPickService.findPickById(pickId);
		Team t = teamService.findTeamById(dp.getTeamId());
		Player p = playerService.findPlayerById(playerId);

		if (dp.getPlayerId() != 0) {
			Player pickedPlayer = this.playerService.findPlayerById(dp.getPlayerId());
			if (pickedPlayer.getTeam2() != null) {
				pickedPlayer.setTeam2(null);
			} else if (pickedPlayer.getTeam1() != null ) {
				pickedPlayer.setTeam1(null);
			}
			this.playerService.persistPlayer(pickedPlayer);
			ArrayList<Player> playerArrayList = new ArrayList<>();
//			Collections.copy(playerArrayList,t.getPlayers());
			playerArrayList.addAll(t.getPlayers());
			for(Player pla :t.getPlayers()){
				if(pla.getId() == dp.getPlayerId()){
					playerArrayList.remove(pla);
				}
			}
			t.setPlayers(playerArrayList);
			this.teamService.persistTeam(t);
		}


		Key<Team> teamKey = Key.create(Team.class,dp.getTeamId());
		Ref<Team> teamRef = Ref.create(teamKey);
		if(p.getTeam1() == null){
			p.setTeam1(teamRef);
		}
		else if(p.getTeam2() == null){
			p.setTeam2(teamRef);
		}
		else{
			throw new Exception("already drafted twice");
		}

		t.getPlayers().add(p);
		teamService.persistTeam(t);

		playerService.persistPlayer(p);
		dp.setPlayerId(p.getId());
		dp.setPlayerName(p.getName());
		draftPickService.persistPick(dp);

	}



	private void makePick(Team team, int round, int pick){
		DraftPick dp = new DraftPick(String.valueOf(round),pick,team.getName(),team.getId());
		System.out.println(dp.toString());
		this.draftPickService.persistPick(dp);
	}

	private String getRoundPick(int numTeams,int pick){

		if(pick % numTeams == 0){
			return (pick/numTeams)+"."+(pick%numTeams == 0 ? numTeams : pick%numTeams);
		}
		return ((pick/numTeams)+1)+"."+(pick%numTeams == 0 ? numTeams : pick%numTeams);
	}

	private ArrayList<Team> forceSort(List<Team> teams){
		ArrayList<Team> data = new ArrayList<>();
		Team currentTeam = null;
		for(int i = 0; i <= teams.size(); i++){
			for(Team t : teams){
				if(t.getDraftPos() == i){
					data.add(t);
				}
			}
		}
		return data;
	}
}
