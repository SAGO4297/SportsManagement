package com.example.SportsManagement.Controller;

import com.example.SportsManagement.Entity.Club;
import com.example.SportsManagement.Entity.Sport;
import com.example.SportsManagement.Service.ClubService;
import java.util.List;

import com.example.SportsManagement.Service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/club")
public class ClubController {

    @Autowired
    private ClubService clubService;
    @Autowired
    private SportService sportService;

    @PostMapping("/addclub/{name}/{sport}")
    public ResponseEntity<?> addClub(@PathVariable String name, @PathVariable String sport) {
        Sport sport1;
        if(sportService.ifExist(sport)) {
            sport1=sportService.findByName(sport);
        }else{
            sport1=new Sport(sport);
        }
        Club club = new Club(name, sport1);
        clubService.addClub(club);
       return ResponseEntity.ok().build();
    }

    @GetMapping("/clubs")
    public ResponseEntity<?> getAllClubs() {
        return ResponseEntity.ok(clubService.getAllClubs()) ;
    }

    @DeleteMapping("/deleteclub/{name}")
    public ResponseEntity<?> deleteClub(@PathVariable String name) {
        clubService.deleteClub(name);
        return ResponseEntity.ok().build();
    }
}
