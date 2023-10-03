package com.example.SportsManagement.Repository;

import com.example.SportsManagement.Entity.Club;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ClubRepository extends JpaRepository<Club, Integer> {

  public Club findByName(String name);
  public Club findById(int id);
//  default Optional<List<Club>> findAllimpl(){
//    Optional<List<Club>> clubs;
//    clubs = Optional.of(this.findAll());
//    return clubs;
//  };

  public List<Club> findAll();

  public Club saveAndFlush(Club club);

  @Modifying
  @Query("DELETE Club c WHERE c.name = ?1")
  void deleteClubByName(String name);

  boolean existsClubByName(String club);
}
