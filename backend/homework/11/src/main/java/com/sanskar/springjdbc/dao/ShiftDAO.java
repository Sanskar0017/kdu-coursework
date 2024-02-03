package com.sanskar.springjdbc.dao;

import com.sanskar.springjdbc.dto.ShiftDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Repository class for managing Shift data access operations.
 */
@Repository
public class ShiftDAO {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Constructs a new ShiftDAO with the provided JdbcTemplate.
     *
     * @param jdbcTemplate the JdbcTemplate instance to be used for database operations.
     */
    @Autowired
    public ShiftDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Adds a new shift to the database.
     *
     * @param shiftDTO the ShiftDTO object containing shift details to be added.
     */
    public void add(ShiftDTO shiftDTO) {
        String psql = "INSERT INTO shifts(id, shift_type_id, name, start_date, end_date, start_time, end_time, created_at, updated_at, created_by, updated_by) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(psql,
                shiftDTO.getId(),
                shiftDTO.getShiftTypeID(),
                shiftDTO.getName(),
                shiftDTO.getStartDate(),
                shiftDTO.getEndDate(),
                shiftDTO.getStartTime(),
                shiftDTO.getEndTime(),
                shiftDTO.getCreatedAt(),
                shiftDTO.getUpdatedAt(),
                shiftDTO.getCreatedBy(),
                shiftDTO.getUpdatedBy());
    }
}
