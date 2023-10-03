package com.example.SportsManagement.Service;

import static org.springframework.http.ResponseEntity.ok;

import com.example.SportsManagement.DAO.ClubDAO;
import com.example.SportsManagement.Entity.Club;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClubService {

      @PersistenceContext
      private EntityManager entityManager;

      @Autowired
      private ClubDAO clubDAO;

      public boolean addClub(Club club) {
           // Optional<List<Club>> clubs = clubDAO.getAllClubs();
            //if(clubs.isPresent()) {
                  //if (clubs.get().contains(club)) {
                        clubDAO.addClub(club);
                       // entityManager.persist(clubDAO);
                        return true;
                  //}
          //  }
            //return false;
      }

      public List<Club> getAllClubs() {
            return clubDAO.getAllClubs();
      }

    public void deleteClub(String name) {
        clubDAO.deleteClub(name);
    }
}
