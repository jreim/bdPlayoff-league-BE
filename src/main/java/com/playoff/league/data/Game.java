package com.playoff.league.data;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Game {

    @Id
    private Long id;
    private Integer order = 0;
    private PlayoffRound round;
    private NFLTeam homeTeam;
    private NFLTeam awayTeam;
    private List<PlayerStat> stats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayoffRound getRound() {
        return round;
    }

    public void setRound(PlayoffRound round) {
        this.round = round;
    }

    public NFLTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(NFLTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public NFLTeam getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(NFLTeam awayTeam) {
        this.awayTeam = awayTeam;
    }

    public List<PlayerStat> getStats() {
        return stats;
    }

    public void setStats(List<PlayerStat> stats) {
        this.stats = stats;
    }
}
