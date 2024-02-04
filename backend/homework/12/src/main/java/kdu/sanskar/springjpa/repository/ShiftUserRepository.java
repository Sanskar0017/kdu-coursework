package kdu.sanskar.springjpa.repository;

import kdu.sanskar.springjpa.model.ShiftUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
/**
 * The ShiftUserRepository interface provides CRUD operations for ShiftUsers entities.
 * It extends the JpaRepository interface, which provides generic CRUD operations for entities.
 * ShiftUsers entities are identified by their UUID.
 */
@Repository
public interface ShiftUserRepository extends JpaRepository<ShiftUsers, UUID> { }
