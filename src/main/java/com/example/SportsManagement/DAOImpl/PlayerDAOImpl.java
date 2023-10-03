package com.example.SportsManagement.DAOImpl;

import com.example.SportsManagement.DAO.PlayerDAO;
import com.example.SportsManagement.Entity.Player;
import com.example.SportsManagement.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class PlayerDAOImpl implements PlayerDAO {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PlayerRepository playerRepository;
    @Override
    public Player save(Player player) {
        Player player1= playerRepository.save(player);
        entityManager.persist(player1);
        return player1;
       //
    }
    @Override
    public void deletePlayerByName(String name) {
        playerRepository.deletePlayerByName(name);
    }
//    @Override
//    public boolean ifExist(String name) {
//        return playerRepository.ifExist(name);
//    }
    @Override
    public Player findByName(String name) {

        return playerRepository.findPlayerByName(name);
    }
    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }
    @Override
    public List<Player> findAllByClub(String name) {
        return playerRepository.findAllByClub(name);
    }
}
