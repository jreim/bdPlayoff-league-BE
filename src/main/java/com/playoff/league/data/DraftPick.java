package com.playoff.league.data;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class DraftPick {

	public DraftPick(String roundPick, Integer draftPos, String teamName, Long teamId) {
		this.roundPick = roundPick;
		this.draftPos = draftPos;
		this.teamName = teamName;
		this.teamId = teamId;
		this.playerId = 0L;
		this.playerName="";
	}
	public DraftPick(){

	}
	@Id
	private Long id;
	private String roundPick;
	private Integer draftPos;
	private String teamName;
	private Long teamId;
	private String playerName;
	private Long playerId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDraftPos() {
		return draftPos;
	}

	public void setDraftPos(Integer draftPos) {
		this.draftPos = draftPos;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public String getRoundPick() {
		return roundPick;
	}

	public void setRoundPick(String roundPick) {
		this.roundPick = roundPick;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	@Override
	public String toString() {
		return "DraftPick{" +
				"id=" + id +
				", roundPick='" + roundPick + '\'' +
				", draftPos=" + draftPos +
				", teamName='" + teamName + '\'' +
				", teamId=" + teamId +
				", playerName='" + playerName + '\'' +
				", playerId=" + playerId +
				'}';
	}
}
