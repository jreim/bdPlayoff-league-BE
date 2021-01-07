package com.playoff.league.rest;

import com.google.appengine.repackaged.com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.playoff.league.data.NFLTeam;
import com.playoff.league.data.Player;
import com.playoff.league.data.PlayerScoreView;
import com.playoff.league.service.DraftPickService;
import com.playoff.league.service.PlayerService;
import com.playoff.league.service.TeamService;
import com.playoff.league.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private DraftPickService draftPickService;
    @GetMapping
    public List<Player> findAllPlayers(){
        return this.playerService.findAllPlayers();
    }
    @PostMapping
    public Player persistPlayer(@RequestBody Player player){
        this.playerService.persistPlayer(player);
        return player;
    }

    @PostMapping("/team/{team}")
    public void persistPlayer(@RequestBody List<Player> players, @PathVariable NFLTeam team){
        for(Player player : players){
            player.setNflTeam(team);
            this.playerService.persistPlayer(player);
        }
    }

    @GetMapping("/team/{team}")
    public List<Player> getPlayersByTeam(@PathVariable NFLTeam team){
       return this.playerService.findAllPlayersByTeam(team);
    }
    @GetMapping("/scoreView/byTeam")
    public List<PlayerScoreView> getViewPlayersByTeam(@RequestParam NFLTeam team){
        List<PlayerScoreView> psvs = new ArrayList<>();
        List<Player> players = this.playerService.findAllPlayers();
        for(Player p :players){
            if(p.getNflTeam() == team){
                psvs.add(new PlayerScoreView(p));
            }
        }
        return psvs;
    }


    @GetMapping("/{playerId}")
    public Player findById(@PathVariable Long playerId){
        return this.playerService.findPlayerById(playerId);
    }

    @DeleteMapping("/{playerId}")
    public void deleteById(@PathVariable Long playerId){
        this.playerService.deletePlayerById(playerId);
    }
//    @GetMapping("/team")
//    public List<Player> findByTeam(){
//        return this.playerService.findPlayersByTeam(NFLTeam.PATRIOITS);
//    }

    @GetMapping("/clearTeams")
    public void clearTeams(){
         this.playerService.clearTeams();
    }

    @GetMapping("/clearTeam/{id}")
    public void clearTeams(@PathVariable Long id){
        this.playerService.clearTeam(id);
    }

    @GetMapping("/loadPlayers")
    public void loadPlayersFromTeams() throws Exception{

        for(NFLTeam team: NFLTeam.values()){

            String data = this.getFileFromResourceAsString(team.getFileLocation());
            Gson gson = new Gson();
            Type listOfMyClassObject = new TypeToken<ArrayList<Player>>() {}.getType();
            List<Player> players = gson.fromJson(data,listOfMyClassObject);

            for(Player p : players){
                p.setNflTeam(team);
                this.playerService.persistPlayer(p);
            }

        }
    }

    private String getFileFromResourceAsString(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return Utils.streamToString(inputStream);
        }

    }


}