package com.playoff.league.data;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;

import java.util.ArrayList;

@Entity
public class PlayerStat {

    @Id
    private Long id;
    @Ignore
    private Integer score;
    private Ref<Player> player;
    private Integer passYd = 0;
    private Integer recYd = 0;
    private Integer rushYd = 0;
    private Integer tPt = 0;
    private Integer dst = 0;
    //tds
    private ArrayList<Integer> rushTd = new ArrayList<>();
    private ArrayList<Integer> passRecTd = new ArrayList<>();
    //kicker sat
    private Integer xp = 0;
    private ArrayList<Integer> fg= new ArrayList<>();
    private PlayoffRound playoffRound;
    private Boolean elim = false;

    public Integer getScore(){
        Integer scoreCalc = 0;
        scoreCalc += getYdScore(this.passYd,20);
        scoreCalc += getYdScore(this.rushYd,10);
        scoreCalc += getYdScore(this.recYd,10);
        scoreCalc += getTdScore(this.passRecTd, false);
        scoreCalc += getTdScore(this.rushTd, true);
        scoreCalc += (tPt*2);
        scoreCalc += getKickerScore(xp, fg);
        scoreCalc += getDst();
        this.score = scoreCalc;
        return scoreCalc;
    }

    private Integer getKickerScore(Integer xp, ArrayList<Integer> fg) {
        int kScore = 0;
        kScore += xp*2;
        for(Integer k : fg){
            if(k <= 39){
                kScore += 5;
            }
            else if(k <= 49){
                kScore += 7;
            }
            else {
                kScore += 10;
            }
        }
        this.score=kScore;
        return kScore;
    }

    public Integer getYdScore(Integer yds, Integer modNum){
        int score;
        if(yds == 0 || yds == null){
            return 0;
        }
        int mod = yds % modNum;
        return (yds - mod)/modNum;
    }

    public Integer getTdScore(ArrayList<Integer> tds, Boolean isRush) {
        int score = 0;
        if(tds.isEmpty()){
            return 0;
        }
        for(Integer td : tds){
            if(td <= 9){
                score += isRush ? 10 : 5;
            }
            else if(td <= 19){
                score += isRush ? 12 : 6;
            }
            else if(td <= 29){
                score += isRush ? 14 : 7;
            }
            else if(td <= 39){
                score += isRush ? 16 : 8;
            }
            else if(td <= 49){
                score += isRush ? 18 : 9;
            }
            else if(td <= 59){
                score += isRush ? 20 : 10;
            }
            else {
                score += isRush ? 25 : 15;
            }
        }
        return score;
    }


    public Ref<Player> getPlayer() {
        return player;
    }

    public void setPlayer(Ref<Player> player) {
        this.player = player;
    }

    public Integer getPassYd() {
        return passYd;
    }

    public void setPassYd(Integer passYd) {
        this.passYd = passYd;
    }

    public Integer getRecYd() {
        return recYd;
    }

    public void setRecYd(Integer recYd) {
        this.recYd = recYd;
    }

    public Integer getRushYd() {
        return rushYd;
    }

    public void setRushYd(Integer rushYd) {
        this.rushYd = rushYd;
    }

    public ArrayList<Integer> getRushTd() {
        return rushTd;
    }

    public void setRushTd(ArrayList<Integer> rushTd) {
        this.rushTd = rushTd;
    }

    public ArrayList<Integer> getPassRecTd() {
        return passRecTd;
    }

    public void setPassRecTd(ArrayList<Integer> passRecTd) {
        this.passRecTd = passRecTd;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public ArrayList<Integer> getFg() {
        return fg;
    }

    public void setFg(ArrayList<Integer> fg) {
        this.fg = fg;
    }

    public Integer getDst() {
        return dst;
    }

    public void setDst(Integer dst) {
        this.dst = dst;
    }

    public Boolean getElim() {
        return elim == null ? Boolean.FALSE : elim;
    }

    public void setElim(Boolean elim) {

        this.elim = elim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer gettPt() {
        return tPt;
    }

    public void settPt(Integer tPt) {
        this.tPt = tPt;
    }

    public PlayoffRound getPlayoffRound() {
        return playoffRound;
    }

    public void setPlayoffRound(PlayoffRound playoffRound) {
        this.playoffRound = playoffRound;
    }
}
