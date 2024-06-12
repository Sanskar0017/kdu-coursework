package com.sanskar.springjdbc.services;

import com.sanskar.springjdbc.dao.ShiftTypeDAO;
import com.sanskar.springjdbc.dto.ShiftTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for managing Shift Types.
 */
@Service
public class ShiftTypeService {

    private final ShiftTypeDAO shiftTypeDAO;

    /**
     * Constructor for ShiftTypeService.
     * @param shiftTypeDAO The DAO for Shift Types.
     */
    @Autowired
    public ShiftTypeService(ShiftTypeDAO shiftTypeDAO) {
        this.shiftTypeDAO = shiftTypeDAO;
    }

    /**
     * Add a new Shift Type.
     * @param shift The Shift Type DTO to be added.
     */
    @Transactional
    public void addShiftTypeService(ShiftTypeDTO shift) {
        shiftTypeDAO.add(shift);
    }
}
