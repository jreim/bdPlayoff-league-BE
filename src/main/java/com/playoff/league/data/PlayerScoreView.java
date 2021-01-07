package com.playoff.league.data;

import com.googlecode.objectify.Ref;

public class PlayerScoreView {

	private String name;
	private Long id;
	private int score;
	private NFLTeam nflTeam;
	private PlayerPosition position;
	private Team team1;
	private Team team2;
	private boolean eliminated = false;
	private String label;
	private PlayerStat wcw;
	private PlayerStat div;
	private PlayerStat champ;
	private PlayerStat sb;

	public PlayerScoreView(Player p){
		this.id = p.getId();
		this.name = p.getName();
		this.score = p.getFinalScore();
		this.position = p.getPosition();
		this.nflTeam = p.getNflTeam();
		if(p.getTeam1() != null){
			this.team1 = p.getTeam1().get();
		}
		if(p.getTeam2() != null){
			this.team2 = p.getTeam2().get();
		}
		this.eliminated = p.isEliminated();
		if( p.getWcwRef() != null){
			this.wcw = p.getWcwRef().get();
			this.wcw.getScore();
		}
		if( p.getDivRef() != null){
			this.div = p.getDivRef().get();
			this.div.getScore();
		}
		if( p.getChampRef() != null){
			this.champ = p.getChampRef().get();
			this.champ.getScore();
		}
		if( p.getSbRef() != null){
			this.sb = p.getSbRef().get();
			this.sb.getScore();
		}

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public NFLTeam getNflTeam() {
		return nflTeam;
	}

	public void setNflTeam(NFLTeam nflTeam) {
		this.nflTeam = nflTeam;
	}

	public PlayerPosition getPosition() {
		return position;
	}

	public void setPosition(PlayerPosition position) {
		this.position = position;
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public boolean isEliminated() {
		return eliminated;
	}

	public void setEliminated(boolean eliminated) {
		this.eliminated = eliminated;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public PlayerStat getWcw() {
		return wcw;
	}

	public void setWcw(PlayerStat wcw) {
		this.wcw = wcw;
	}

	public PlayerStat getDiv() {
		return div;
	}

	public void setDiv(PlayerStat div) {
		this.div = div;
	}

	public PlayerStat getChamp() {
		return champ;
	}

	public void setChamp(PlayerStat champ) {
		this.champ = champ;
	}

	public PlayerStat getSb() {
		return sb;
	}

	public void setSb(PlayerStat sb) {
		this.sb = sb;
	}
}
