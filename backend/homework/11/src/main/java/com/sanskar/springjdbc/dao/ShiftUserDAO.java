package com.sanskar.springjdbc.dao;

import com.sanskar.springjdbc.dto.ShiftUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Repository class for handling Shift User data access operations.
 */
@Repository
public class ShiftUserDAO {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Constructor for initializing the ShiftUserDAO with a JdbcTemplate instance.
     *
     * @param jdbcTemplate JdbcTemplate instance to be used for database operations.
     */
    @Autowired
    public ShiftUserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Adds a new shift user record to the database.
     *
     * @param shiftUserDTO ShiftUserDTO object containing the shift user data to be added.
     */
    public void add(ShiftUserDTO shiftUserDTO) {
        String psql = "INSERT INTO shift_users(id, shift_id, user_id, tenant_id, created_at, updated_at, created_by, updated_by) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(psql,
                shiftUserDTO.getId(),
                shiftUserDTO.getShiftID(),
                shiftUserDTO.getUserID(),
                shiftUserDTO.getTenantID(),
                shiftUserDTO.getCreatedAt(),
                shiftUserDTO.getUpdatedAt(),
                shiftUserDTO.getCreatedBy(),
                shiftUserDTO.getUpdatedBy());
    }
}
