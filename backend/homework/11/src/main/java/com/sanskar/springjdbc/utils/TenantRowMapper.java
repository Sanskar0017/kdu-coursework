package com.sanskar.springjdbc.utils;

import com.sanskar.springjdbc.model.Tenants;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * RowMapper implementation for mapping ResultSet rows to Tenants objects.
 */
public class TenantRowMapper implements RowMapper<Tenants> {

    /**
     * Maps a ResultSet row to a Tenants object.
     *
     * @param rs     The ResultSet containing the data to be mapped
     * @param rowNum The number of the current row being processed
     * @return A Tenants object mapped from the ResultSet row
     * @throws SQLException if an SQL exception occurs while accessing the ResultSet
     */
    @Override
    public Tenants mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Tenants(
                UUID.fromString(rs.getString("id")),
                rs.getString("name"),
                rs.getDate("created_at"),
                rs.getDate("updated_at"),
                rs.getString("created_by"),
                rs.getString("updated_by")
        );
    }
}
