package com.playoff.league.data;

import java.util.ArrayList;
import java.util.List;

public class TeamScoreView {

	private String name;
	private List<PlayerScoreView> players;
	private Integer score = 0;
	private Integer playersRemaining = 8;

	public TeamScoreView(Team t){
		this.name = t.getName();
		this.players = new ArrayList<>();
		for(Player p: t.getPlayers()){
			PlayerScoreView currentPSV = new PlayerScoreView(p);
			this.players.add(currentPSV);
			this.score += currentPSV.getScore();
			if(currentPSV.isEliminated()){
				this.playersRemaining--;
			}
		}
	}

}
