package com.sanskar.springjdbc.utils;

import com.sanskar.springjdbc.model.Users;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * RowMapper implementation for mapping ResultSet to Users entity.
 */
public class UserRowMapper implements RowMapper<Users> {

    /**
     * Maps a row of the ResultSet to a Users entity.
     *
     * @param rs     the ResultSet containing the data
     * @param rowNum the current row number
     * @return a Users entity mapped from the ResultSet
     * @throws SQLException if a SQLException is encountered
     */
    @Override
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Users(
                UUID.fromString(rs.getString("id")),
                rs.getString("user_name"),
                rs.getInt("logged_in"),
                rs.getString("time_zone"),
                UUID.fromString(rs.getString("tenant_id")),
                rs.getDate("created_at"),
                rs.getDate("updated_at"),
                rs.getString("created_by"),
                rs.getString("updated_by")
        );
    }
}
