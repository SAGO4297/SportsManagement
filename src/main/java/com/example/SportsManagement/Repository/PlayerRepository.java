package com.example.SportsManagement.Repository;

import com.example.SportsManagement.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

    @Override
    List<Player> findAll();
    @Modifying
    Player save(Player player);

    Player findPlayerByName(String name);
    List<Player> findAllByClub(String name);
//    @Override
//    void deleteById(Integer integer);
//
//    @Override
//    void delete(Player entity);

    void deletePlayerByName(String name);

    //boolean ifExist(String name);
}
