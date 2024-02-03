package com.sanskar.springjdbc.services;

import com.sanskar.springjdbc.dao.TenantDAO;
import com.sanskar.springjdbc.dto.AllTenantDTO;
import com.sanskar.springjdbc.dto.TenantDTO;
import com.sanskar.springjdbc.model.Tenants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class for managing tenants.
 */
@Service
public class TenantService {

    private static TenantDAO tenantDAO;

    /**
     * Constructor-based dependency injection for TenantService.
     *
     * @param tenantDAO the tenant DAO to be injected
     */
    @Autowired
    public TenantService(TenantDAO tenantDAO) {
        TenantService.tenantDAO = tenantDAO;
    }

    /**
     * Adds all tenants in one transactional operation.
     *
     * @param allTenantDTO the DTO containing all tenant information
     */
    @Transactional
    public static void addAllTenantsOneGo(AllTenantDTO allTenantDTO) {
        tenantDAO.addAllTenants(allTenantDTO);
    }

    /**
     * Adds a new tenant.
     *
     * @param tenant the DTO representing the new tenant
     * @return the index of the newly added tenant
     */
    @Transactional
    public int addTenant(TenantDTO tenant) {
        return tenantDAO.add(tenant);
    }

    /**
     * Retrieves all tenants.
     *
     * @return the list of all tenants
     */
    public List<Tenants> getAllTenant() {
        return tenantDAO.getAllTenants();
    }
}
