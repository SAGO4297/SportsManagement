package com.example.SportsManagement.Repository;

import com.example.SportsManagement.Entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SportRepository extends JpaRepository<Sport, Integer> {
    List<Sport> findAll();
    Sport findByName(String name);
    boolean existsByName(String name);
    Sport save(Sport sport);

    void deleteByName(String name);
}
