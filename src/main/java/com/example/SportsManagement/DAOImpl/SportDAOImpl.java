package com.example.SportsManagement.DAOImpl;

import com.example.SportsManagement.DAO.SportDAO;
import com.example.SportsManagement.Entity.Sport;
import com.example.SportsManagement.Repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class SportDAOImpl implements SportDAO {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private SportRepository sportRepository;

    @Override
    public void addSport(String name) {
        sportRepository.saveAndFlush(new Sport(name));
    }

    public boolean ifExist(String name) {
        return sportRepository.existsByName(name);
    }

    @Override
    public Sport findByName(String name) {
        return sportRepository.findByName(name);
    }

    @Override
    public void removeSport(String name) {
        sportRepository.deleteByName(name);
    }
}
