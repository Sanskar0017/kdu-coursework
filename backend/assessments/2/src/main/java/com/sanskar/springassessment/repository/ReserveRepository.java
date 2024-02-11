package com.sanskar.springassessment.repository;

import com.sanskar.springassessment.dto.ReserveDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ReserveRepo consisting of reserveDTO
 */
@Repository
public interface ReserveRepository extends JpaRepository<ReserveDTO, Integer> {
}
