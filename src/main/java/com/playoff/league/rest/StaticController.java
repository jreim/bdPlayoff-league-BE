package com.playoff.league.rest;

import com.playoff.league.data.NFLTeam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/static")
public class StaticController {


	@GetMapping(value = "/nflTeams", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<NFLTeam> nflTeamStrings(){
//		GsonBuilder gb = new GsonBuilder();
//
//		gb.registerTypeAdapter(NFLTeam.class, new NFLTeamSerialzer());
//		Gson g = gb.create();

		List<NFLTeam> teams = new ArrayList<NFLTeam>();
		for(NFLTeam team : NFLTeam.values()){
//			if(NFLTeam.CONF.AFC.equals(team.getConf())){
				teams.add(team);
//			}
		}
		return teams;

	}
}
