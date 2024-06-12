package com.sanskar.springjdbc.dao;

import com.sanskar.springjdbc.dto.UserDTO;
import com.sanskar.springjdbc.model.Users;
import com.sanskar.springjdbc.utils.UserRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This class represents the Data Access Object (DAO) for managing user data.
 */
@Repository
@Slf4j
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Constructs a new UserDAO with the provided JdbcTemplate.
     *
     * @param jdbcTemplate The JdbcTemplate to be used for database operations.
     */
    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Adds a new user to the database.
     *
     * @param userDTO The UserDTO object containing user information.
     * @return The number of rows affected by the operation.
     * @throws Exception if an error occurs during the database operation.
     */
    public int add(UserDTO userDTO) {
        try {
            log.info("Adding user");
            String psqlStatement = "INSERT INTO users (id, user_name, logged_in, time_zone, tenant_id, created_at, updated_at, created_by, updated_by) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            return jdbcTemplate.update(psqlStatement,
                    userDTO.getId(),
                    userDTO.getUserName(),
                    userDTO.getLoggedIn(),
                    userDTO.getTimeZone(),
                    userDTO.getTenantID(),
                    userDTO.getCreatedAt(),
                    userDTO.getUpdatedAt(),
                    userDTO.getCreatedBy(),
                    userDTO.getUpdatedBy());
        } catch (Exception e) {
            log.error("An exception occurred while adding user: {}", e.getMessage());
            throw e;
        }
    }

    /**
     * Retrieves a list of all users from the database.
     *
     * @return A List of Users objects representing all users in the database.
     */
    public List<Users> getAllUsers() {
        return jdbcTemplate.query("Select * from users", new UserRowMapper());
    }
}
