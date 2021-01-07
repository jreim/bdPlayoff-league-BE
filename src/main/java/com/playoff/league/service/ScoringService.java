package com.playoff.league.service;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.playoff.league.data.Game;
import com.playoff.league.data.Player;
import com.playoff.league.data.PlayerStat;
import com.playoff.league.data.Team;
import com.playoff.league.util.Utils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//@Component
public class ScoringService {


//    private Gson gson = new Gson();
////    private HashMap<String,ArrayList<Game>> playoffs = new HashMap<>();
//    private ArrayList<Team> teams = new ArrayList<>();
//    private HashMap<String,Player> players = new HashMap<>();
//
////    @PostConstruct
////    private void BootStrap() {
////
////        buildPlayerLines();
////    }
//
//
//
//    public void buildPlayerLines(){
//
//
//        teams = new ArrayList<>();
//        players = new HashMap<>();
//        File wcwDir = new File(dataDir + "/wcw");
//        this.processRound(wcwDir,"wcw");
//        File divDir = new File(dataDir + "/div");
//        this.processRound(divDir,"div");
////
//        File champDir = new File(dataDir + "/champ");
//        this.processRound(champDir,"champ");
////
////
//        File sbDir = new File(dataDir + "/sb");
//        this.processRound(sbDir,"sb");
//
//        JsonParser parser = new JsonParser();
//        JsonArray ts = parser.parse(Utils.getFileData(new File("/Users/jessereim/dev/personal/projects/League/data18/Teams.json"))).getAsJsonArray();
//
//        for (JsonElement t : ts) {
//            Team te = gson.fromJson(t,Team.class);
////            for(String pl : te.getPlayersNames()){
////                Player p = players.get(pl);
////                if(p == null){
////                    p = new Player();
////                    p.setName(pl);
////                }
////                te.getPlayers().add(p);
////            }
//            teams.add(te);
//
//        }
//
//        List<Player> sortedPlayers = new ArrayList();
//
//        for(Player p : players.values()){
//            sortedPlayers.add(p);
//        }
//
//        Collections.sort(sortedPlayers);
//        StringBuilder sb = new StringBuilder();
//
//        Collections.sort(teams);
////        for(Team t : teams){
////            sb.append(t.dumpTeamView());
////        }
//
//        Collections.sort(sortedPlayers);
//        for(Player p : sortedPlayers){
//            System.out.println(p.getName()+" : "+p.getFinalScore() );
//        }
////        Player player = sortedPlayers.get(0);
////        Utils.writeFile(sb.toString(),player.getName() + " : " + player.getFinalScore());
//    }
//
//    private void processRound(File dir, String round){
//        File[] files = dir.listFiles();
//        for (File f : files) {
//            Game g = gson.fromJson(Utils.getFileData(f), Game.class);
//            for(PlayerStat ps : g.getStats()){
//
////                if(!players.containsKey(ps.getName())){
////                    Player p =  new Player();
////                    p.setName(ps.getName());
////                    players.put(ps.getName(),p);
////                }
////
////                if("wcw".equals(round)){
////                    players.get(ps.getName()).setWcw( ps);
////                }
////                else if("div".equals(round)){
////                    players.get(ps.getName()).setDiv(ps);
////                }
////                else if("champ".equals(round)){
////                    players.get(ps.getName()).setChamp(ps);
////                }
////                else if("sb".equals(round)){
////                    players.get(ps.getName()).setSb(ps);
////                }
//
//            }
//        }
//    }
//
//
//    private String dataDir = "/Users/jessereim/dev/personal/projects/League/data18";
//


}
