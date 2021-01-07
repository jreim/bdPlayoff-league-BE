package com.playoff.league.data;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Player implements Comparable<Player>{

    @Id
    private Long id;
    private String name;
//    private Ref<NFLTeam> nflTeamRef;
    private NFLTeam nflTeam;
    private PlayerPosition position;
    private Ref<Team> team1;
    private Ref<Team> team2;
    private boolean eliminated = false;
    private String label;
    private Ref<PlayerStat> wcw;
    private Ref<PlayerStat> div;
    private Ref<PlayerStat> champ;
    private Ref<PlayerStat> sb;



    private String[] getData(){
        String[] data = new String[6];
        return data;
    }

    public Integer getFinalScore(){

        int wcwScore = wcw == null? 0: wcw.get().getScore();
        int divScore = div == null? 0: div.get().getScore();
        int chanpScore = champ == null? 0: champ.get().getScore();
        int sbScore = sb == null? 0: sb.get().getScore();
        return wcwScore +
                divScore +
                chanpScore +
                sbScore;


    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEliminated() {
        boolean wcwE = wcw == null ? false : wcw.get().getElim();
        boolean divE = div == null ? false : div.get().getElim();
        boolean champE = champ == null ? false : champ.get().getElim();

        return wcwE || divE || champE;
    }

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }

    public Ref<PlayerStat> getWcwRef() {
        return wcw;
    }

    public Ref<PlayerStat> getDivRef() {
        return div;
    }

    public Ref<PlayerStat> getChampRef() {
        return champ;
    }

    public PlayerStat getSb() {
        return sb.get();
    }
    public Ref<PlayerStat> getSbRef() {
        return sb;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Ref<Team> getTeam1() {
        return team1;
    }

    public void setTeam1(Ref<Team> team1) {
        this.team1 = team1;
    }

    public Ref<Team> getTeam2() {
        return team2;
    }

    public void setTeam2(Ref<Team> team2) {
        this.team2 = team2;
    }

    public void setWcw(Ref<PlayerStat> wcw) {
        this.wcw = wcw;
    }

    public void setDiv(Ref<PlayerStat> div) {
        this.div = div;
    }

    public void setChamp(Ref<PlayerStat> champ) {
        this.champ = champ;
    }

    public void setSb(Ref<PlayerStat> sb) {
        this.sb = sb;
    }

    public String getLabel(){
        return this.name + " - " + position + " - " +
            nflTeam == null ? "NULL":nflTeam.name();
    }
    @Override
    public int compareTo(Player o) {

        if(o.getFinalScore() > this.getFinalScore()){
            return 1;
        }
        return -1;
    }
}
