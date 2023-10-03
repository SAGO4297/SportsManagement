package com.example.SportsManagement.DAO;

import com.example.SportsManagement.Entity.Sport;

public interface SportDAO {
    void addSport(String name);
    void removeSport(String name);
    boolean ifExist(String name);

    Sport findByName(String name);
}
