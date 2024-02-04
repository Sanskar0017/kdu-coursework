package kdu.sanskar.springjpa.repository;

import kdu.sanskar.springjpa.model.Tenants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
/**
 * The TenantRepository interface provides methods for accessing and managing
 * Tenant entities in the database.
 */
@Repository
public interface TenantRepository extends JpaRepository<Tenants, UUID> {
}
