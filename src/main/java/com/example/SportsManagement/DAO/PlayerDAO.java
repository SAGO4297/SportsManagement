package com.example.SportsManagement.DAO;

import com.example.SportsManagement.Entity.Player;

import java.util.List;

public interface PlayerDAO {
 //   void addPlayer(String name, String sport, String club, int age);
   // void removePlayer(String name);

    Player save(Player player);

    void deletePlayerByName(String name);

    //boolean ifExist(String name);
    Player findByName(String name);
    List<Player> findAll();

    List<Player> findAllByClub(String name);
}
