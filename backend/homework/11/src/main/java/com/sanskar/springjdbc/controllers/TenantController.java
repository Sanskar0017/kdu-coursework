package com.sanskar.springjdbc.controllers;

import com.sanskar.springjdbc.dto.AllTenantDTO;
import com.sanskar.springjdbc.dto.TenantDTO;
import com.sanskar.springjdbc.exceptions.RecordNotFoundException;
import com.sanskar.springjdbc.model.Tenants;
import com.sanskar.springjdbc.services.TenantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing tenant-related endpoints.
 */
@RestController
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
    public ResponseEntity<Integer> addTenant(@Valid @RequestBody TenantDTO tenant) {
        int index = tenantService.addTenant(tenant);
        return new ResponseEntity<>(index, HttpStatus.OK);
    }

    /**
     * Endpoint to add all tenants in one go.
     *
     * @param allTenantDTO the AllTenantDTO object containing all tenant data
     * @return ResponseEntity with a success message and HttpStatus. OK
     */
    @PostMapping("/addAllTenants")
    public ResponseEntity<String> addAllTenant(@Valid @RequestBody AllTenantDTO allTenantDTO)  {
        TenantService.addAllTenantsOneGo(allTenantDTO);
        return new ResponseEntity<>("All tenants added in one go", HttpStatus.OK);
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
