package com.example.SportsManagement.DAOImpl;

import com.example.SportsManagement.DAO.ClubDAO;
import com.example.SportsManagement.Entity.Club;
import com.example.SportsManagement.Repository.ClubRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ClubDAOImpl implements ClubDAO {
    @Autowired
    private ClubRepository clubRepository;
    @Override
    public void addClub(Club club) {
      clubRepository.saveAndFlush(club);
    }

    public Club findByName(String name) {
        return clubRepository.findByName(name);
    }

    @Override
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    @Override
    public void deleteClub(String name) {
        clubRepository.deleteClubByName(name);
    }

    @Override
    public boolean ifExist(String club) {
        return clubRepository.existsClubByName(club);
    }
}
