package com.example.SportsManagement.DAO;

import com.example.SportsManagement.Entity.Club;
import java.util.List;


public interface ClubDAO {
      void addClub(Club club);

      List<Club> getAllClubs();

      void deleteClub(String name);

      public Club findByName(String name);

      boolean ifExist(String club);
}
