package com.sanskar.springjdbc.services;

import com.sanskar.springjdbc.dao.ShiftDAO;
import com.sanskar.springjdbc.dto.ShiftDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for managing shifts.
 */
@Service
public class ShiftService {

    private final ShiftDAO shiftDAO;

    /**
     * Constructs a new ShiftService with the provided ShiftDAO.
     *
     * @param shiftDAO the data access object for shifts
     */
    @Autowired
    public ShiftService(ShiftDAO shiftDAO) {
        this.shiftDAO = shiftDAO;
    }

    /**
     * Adds a new shift.
     *
     * @param shift the shift to add
     */
    @Transactional
    public void addShiftService(ShiftDTO shift) {
        shiftDAO.add(shift);
    }
}
