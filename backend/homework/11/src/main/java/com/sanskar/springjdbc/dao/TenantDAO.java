package com.sanskar.springjdbc.dao;

import com.sanskar.springjdbc.dto.AllTenantDTO;
import com.sanskar.springjdbc.dto.TenantDTO;
import com.sanskar.springjdbc.model.Tenants;
import com.sanskar.springjdbc.utils.TenantRowMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Data Access Object (DAO) for managing Tenant-related database operations.
 */
@Repository
@Slf4j
public class TenantDAO {

    private final JdbcTemplate jdbcTemplate;
    private final UserDAO userDAO;
    private final ShiftTypeDAO shiftTypeDAO;
    private final ShiftUserDAO shiftUserDAO;
    private final ShiftDAO shiftDAO;

    /**
     * Constructor for TenantDAO.
     *
     * @param jdbcTemplate  JdbcTemplate for executing SQL queries.
     * @param userDAO       UserDAO for user-related operations.
     * @param shiftTypeDAO  ShiftTypeDAO for shift type-related operations.
     * @param shiftUserDAO  ShiftUserDAO for shift user-related operations.
     * @param shiftDAO      ShiftDAO for shift-related operations.
     */
    @Autowired
    public TenantDAO(JdbcTemplate jdbcTemplate, UserDAO userDAO, ShiftTypeDAO shiftTypeDAO,
                     ShiftUserDAO shiftUserDAO, ShiftDAO shiftDAO) {
        this.jdbcTemplate = jdbcTemplate;
        this.userDAO = userDAO;
        this.shiftTypeDAO = shiftTypeDAO;
        this.shiftUserDAO = shiftUserDAO;
        this.shiftDAO = shiftDAO;
    }

    /**
     * Add a new tenant to the database.
     *
     * @param tenants The TenantDTO containing information about the tenant to be added.
     * @return The number of rows affected by the insertion operation.
     */
    public int add(TenantDTO tenants){
        try{
            log.info("Adding tenant");
            String psqlStatement = "INSERT INTO tenants (id, name, created_by, updated_by) VALUES (?, ?, ?, ?)";
            return jdbcTemplate.update(psqlStatement, tenants.getId(), tenants.getName(), tenants.getCreatedBy(), tenants.getUpdatedBy());
        } catch(Exception e){
            log.info("Error caught in adding tenant");
            throw e;
        }
    }

    /**
     * Add all tenants in one go, including users, shift types, shifts, and shift users.
     *
     * @param allTenantDTO The AllTenantDTO containing information about all tenants to be added.
     */
    @Transactional
    public void addAllTenants(AllTenantDTO allTenantDTO) {
        try{
            log.info("Adding all tenants in one go");
            userDAO.add(allTenantDTO.getUserDTO());
            shiftTypeDAO.add(allTenantDTO.getShiftTypeDTO());
            shiftDAO.add(allTenantDTO.getShiftDTO());
            shiftUserDAO.add(allTenantDTO.getShiftUserDTO());
        } catch (Exception e){
            log.info("Error adding all tenants simultaneously");
        }
    }

    /**
     * Retrieve all tenants from the database.
     *
     * @return A list of Tenants retrieved from the database.
     */
    public List<Tenants> getAllTenants() {
        return jdbcTemplate.query("SELECT * FROM tenants", new TenantRowMapper());
    }
}
