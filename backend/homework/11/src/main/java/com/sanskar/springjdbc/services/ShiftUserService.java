package com.sanskar.springjdbc.services;

import com.sanskar.springjdbc.dao.ShiftUserDAO;
import com.sanskar.springjdbc.dto.ShiftUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for managing shift users.
 */
@Service
public class ShiftUserService {

    private final ShiftUserDAO shiftUserDAO;

    /**
     * Constructs a new ShiftUserService with the specified ShiftUserDAO.
     *
     * @param shiftUserDAO The data access object for shift users.
     */
    @Autowired
    public ShiftUserService(ShiftUserDAO shiftUserDAO) {
        this.shiftUserDAO = shiftUserDAO;
    }

    /**
     * Adds a new shift user.
     *
     * @param shiftUser The shift user DTO to be added.
     */
    @Transactional
    public void addShiftUser(ShiftUserDTO shiftUser) {
        shiftUserDAO.add(shiftUser);
    }
}
