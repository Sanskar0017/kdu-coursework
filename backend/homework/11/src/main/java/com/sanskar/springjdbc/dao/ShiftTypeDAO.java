package com.sanskar.springjdbc.dao;

import com.sanskar.springjdbc.dto.ShiftTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * This class provides data access operations for ShiftType entities.
 */
@Repository
public class ShiftTypeDAO {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Constructs a new ShiftTypeDAO with the specified JdbcTemplate.
     *
     * @param jdbcTemplate the JdbcTemplate to be used for database operations
     */
    @Autowired
    public ShiftTypeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Inserts a new ShiftTypeDTO into the database.
     *
     * @param shiftTypeDTO the ShiftTypeDTO object to be inserted
     */
    public void add(ShiftTypeDTO shiftTypeDTO) {
        String psql = "INSERT INTO shift_types(id, uq_name, description, active, time_zone, tenant_id, created_at, updated_at, created_by, updated_by) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(psql,
                shiftTypeDTO.getId(),
                shiftTypeDTO.getUqName(),
                shiftTypeDTO.getDescription(),
                shiftTypeDTO.isActive(),
                shiftTypeDTO.getTimeZone(),
                shiftTypeDTO.getTenantID(),
                shiftTypeDTO.getCreatedAt(),
                shiftTypeDTO.getUpdatedAt(),
                shiftTypeDTO.getCreatedBy(),
                shiftTypeDTO.getUpdatedBy());
    }
}
