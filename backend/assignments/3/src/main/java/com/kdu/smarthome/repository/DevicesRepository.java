package com.kdu.smarthome.repository;

import com.kdu.smarthome.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DevicesRepository extends JpaRepository<Device, Integer> {
    Optional<Device> findBykickstonId(String kickstonId);
}
