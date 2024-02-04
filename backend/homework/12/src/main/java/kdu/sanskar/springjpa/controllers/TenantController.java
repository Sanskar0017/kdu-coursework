/**
 * Controller class for managing tenant-related endpoints.
 */
package kdu.sanskar.springjpa.controllers;

import kdu.sanskar.springjpa.exceptions.RecordNotFoundException;
import kdu.sanskar.springjpa.model.Tenants;
import kdu.sanskar.springjpa.services.TenantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class for managing tenant-related endpoints.
 */
@RestController
@Slf4j
public class TenantController {

    private final TenantService tenantService;

    /**
     * Constructs a new TenantController instance.
     *
     * @param tenantService the TenantService instance to be injected
     */
    @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    /**
     * Endpoint to add a new tenant.
     *
     * @param tenant the TenantDTO object representing the new tenant
     * @return ResponseEntity with the index of the added tenant and HttpStatus. OK
     */
    @PostMapping("/addTenant")
    public ResponseEntity<String> addTenant(@RequestBody Tenants tenant) {
        log.info("Adding Tenant");
        tenantService.addTenant(tenant);
        return new ResponseEntity<>("Tenant added successfully", HttpStatus.OK);
    }


    /**
     * Endpoint to retrieve all tenants.
     *
     * @return ResponseEntity with the list of all tenants and HttpStatus. OK
     * @throws RecordNotFoundException if no tenants are found
     */
    @GetMapping("/allTenant")
    public ResponseEntity<List<Tenants>> getAllTenants() throws RecordNotFoundException {
        List<Tenants> allTenantList = tenantService.getAllTenant();
        return new ResponseEntity<>(allTenantList, HttpStatus.OK);
    }
}
