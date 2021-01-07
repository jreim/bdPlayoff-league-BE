package com.playoff.league.data;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Team implements Comparable<Team> {

    @Id
    private Long id;
    private Integer draftPos = 0;
    private String name;
    private String email;
//    private ArrayList<String> playersNames;
    private List<Player> players;
    private Integer score = 0;
    private Integer playersRemaining = 8;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        Integer score = 0;
//        for(Player p : players){
//            if(p.isEliminated()) {
//                playersRemaining = playersRemaining-1;
//            }
//            score += p.getFinalScore();
//        }
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getPlayersRemaining() {
        return playersRemaining;
    }

    public void setPlayersRemaining(Integer playersRemaining) {
        this.playersRemaining = playersRemaining;
    }

    public List<Player> getPlayers() {

        if(this.players == null) {
            this.setPlayers(new ArrayList<>());
        }
        return this.players;
    }


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    //    public String dumpTeamView(){
//        playersRemaining = 8;
//        score = 0;
//        String[] data = new String[5];
//        data[0] = this.name;
//        StringBuilder sb = new StringBuilder();
//
//        for(Player p : players){
//            sb.append(p.getPlayerLine() + "\n");
//            if(p.isEliminated()) {
//                playersRemaining = playersRemaining-1;
//            }
//            score += p.getFinalScore();
//        }
//        data[2] = playersRemaining.toString();
//        data[1] = score.toString();
//        data[3] = sb.toString();
//        data[4] = Integer.toString(this.hashCode());
//
//        return String.format(TEAM_VIEW, data);
//    }
//
//    private static final String TEAM_VIEW=
//            "<div class=\"panel panel-default\">\n" +
//                    "    <div class=\"panel-heading\" role=\"tab\" id=\"headingOne\">\n" +
//                    "        <h4 class=\"panel-title\">\n" +
//                    "          <div class=\"row\">\n" +
//                    "            <a class=\"col-md-4\" role=\"button\" data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#%5$s\" aria-expanded=\"false\" aria-controls=\"%5$s\">\n" +
//                    "                %1$s\n" +
//                    "            </a>\n" +
//                    "            <div class=\"col-md-3\">Players Remaining: %3$s</div>\n" +
//                    "            <div class=\"col-md-offset-3 col-md-2\">Points : %2$s</div>\n" +
//                    "          </div>\n" +
//                    "        </h4>\n" +
//                    "    </div>\n" +
//                    "    <div id=\"%5$s\" class=\"panel-collapse collapse\" role=\"tabpanel\" aria-labelledby=\"headingOne\">\n" +
//                    "        <div class=\"panel-body\">\n" +
//                    "          <table class=\"table table-condensed\">\n" +
//                    "            <thead>\n" +
//                    "              <tr>\n" +
//                    "                <th>Player</th>\n" +
//                    "                <th>Wild Card</th>\n" +
//                    "                <th>Divisional</th>\n" +
//                    "                <th>Chamionship</th>\n" +
//                    "                <th>SuperBowl</th>\n" +
//                    "                <th>Total</th>\n" +
//                    "              </tr>\n" +
//                    "            </thead>\n" +
//                    "            <tbody>\n" +
//                    "                %4$s\n" +
//                    "            </tbody>\n" +
//                    "\n" +
//                    "        </table>\n" +
//                    "        </div>\n" +
//                    "    </div>\n" +
//                    "</div>\n";
//
    @Override
    public int compareTo(Team t) {
        if(t.getDraftPos() < this.getDraftPos()){
            return 0;
        }
        return -1;
    }
}
