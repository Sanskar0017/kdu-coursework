package kdu.sanskar.springjpa.repository;

import kdu.sanskar.springjpa.model.ShiftTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
/**
 * The ShiftTypeRepository interface provides CRUD operations for ShiftTypes entities.
 * It extends the JpaRepository interface with ShiftTypes as the entity type and UUID as the primary key type.
 */
@Repository
public interface ShiftTypeRepository extends JpaRepository<ShiftTypes, UUID> {
}
