package com.example.SportsManagement.Service;

import com.example.SportsManagement.DAO.ClubDAO;
import com.example.SportsManagement.DAO.PlayerDAO;
import com.example.SportsManagement.DAO.SportDAO;
import com.example.SportsManagement.Entity.Club;
import com.example.SportsManagement.Entity.Player;
import com.example.SportsManagement.Entity.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerDAO playerDAO;
    @Autowired
    private SportDAO sportDAO;
    @Autowired
    private ClubDAO clubDAO;

    public boolean addPlayer(String name, String sport, String club, String gender, int age) {
        if (!clubDAO.ifExist(club)) {
            return false;
        }else {
           // Sport sport1 = sportDAO.findByName(sport);
            Club club1 = clubDAO.findByName(club);
            Sport sport1 = club1.getSport();
            Player player = new Player(name, sport1, gender, club1, age);
            playerDAO.save(player);
            return true;
        }
      //  Player player = new Player(name, sport, club, gender, age);
       // playerDAO.addPlayer(name, sport, club,age );
    }

    public void deletePlayerByName(String name) {
        playerDAO.deletePlayerByName(name);
    }

//    public boolean ifExist(String name) {
//        return playerDAO.ifExist(name);
//    }

    public List<Player> findAll() {
        return playerDAO.findAll();
    }
    public Player findByName(String name) {
        return playerDAO.findByName(name);
    }
    public List<Player> findAllByClub(String name) {
        return playerDAO.findAllByClub(name);
    }
}
