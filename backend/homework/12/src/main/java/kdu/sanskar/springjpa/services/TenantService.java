package kdu.sanskar.springjpa.services;
import kdu.sanskar.springjpa.model.Tenants;
import kdu.sanskar.springjpa.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * This service class provides methods to interact with the Tenant entity.
 */
@Service
@Transactional
public class TenantService {

    private final TenantRepository tenantRepository;
    /**
     * Constructs a TenantService with the specified TenantRepository.
     * @param tenantRepository the repository for Tenant entities.
     */
    @Autowired
    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }
    /**
     * Adds a new Tenant to the database.
     * @param tenants the Tenant object to add.
     */
    public void addTenant(Tenants tenants){
        tenantRepository.save(tenants);
    }

    /**
     * Retrieves a list of all Tenants from the database.
     * @return a list of all Tenants.
     */
    public List<Tenants> getAllTenant(){
        return tenantRepository.findAll();
    }
}
