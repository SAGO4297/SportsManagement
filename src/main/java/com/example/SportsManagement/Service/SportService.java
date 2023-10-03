package com.example.SportsManagement.Service;

import com.example.SportsManagement.DAO.SportDAO;
import com.example.SportsManagement.Entity.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportService {

    @Autowired
    private SportDAO sportDAO;
    public void addSport(String name) {
        if (!sportDAO.ifExist(name)) {
            sportDAO.addSport(name);
        }
    }

    public boolean ifExist(String name) {
        return sportDAO.ifExist(name);
    }
    public Sport findByName(String name) {
        return sportDAO.findByName(name);
    }
}
