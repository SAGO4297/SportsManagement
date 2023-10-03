package com.example.SportsManagement.Controller;

import com.example.SportsManagement.Entity.Player;
import com.example.SportsManagement.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @PostMapping("/addplayer/{name}")
    public ResponseEntity<?> addPlayer(@PathVariable String name,@RequestParam String sport,@RequestParam String gender,@RequestParam String club,@RequestParam int age) {
        playerService.addPlayer(name,sport,gender,club,age);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/removeplayer/{name}")
    public ResponseEntity<?> deletePlayerByName(@PathVariable String name) {
        playerService.deletePlayerByName(name);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/allplayers")
    public ResponseEntity<?> findAllPlayers() {
        return ResponseEntity.ok(playerService.findAll());
    }
    @GetMapping("/player/{name}")
    public ResponseEntity<?> findPlayerByName(@PathParam("name") String name) {
        return ResponseEntity.ok(playerService.findByName(name));
    }

    @GetMapping("/player/club/{name}")
    public ResponseEntity<?> findPlayerByClub(@PathParam("name") String name) {
        return ResponseEntity.ok(playerService.findAllByClub(name));
    }


}
