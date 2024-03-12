package kdu.sanskar.springjpa.repository;

import kdu.sanskar.springjpa.model.Shifts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;
/**
 * This repository interface extends JpaRepository for Shift entities.
 */
@Repository
public interface ShiftRepository extends JpaRepository<Shifts, UUID> {
    /**
     * Retrieves the top 3 Shift entities with the given start date and end date.
     *
     * @param startDate the start date of the shifts
     * @param endDate the end date of the shifts
     * @return a list of Shift entities matching the criteria, ordered by name
     */
    @Query("SELECT s FROM Shifts s WHERE s.startDate = :startDate AND s.endDate = :endDate ORDER BY s.name ASC")
    List<Shifts> findTop3Shifts(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
