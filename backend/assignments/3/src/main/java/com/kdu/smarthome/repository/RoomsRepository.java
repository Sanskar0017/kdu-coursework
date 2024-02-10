package com.kdu.smarthome.repository;

import com.kdu.smarthome.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomsRepository extends JpaRepository<Room, Integer> {
}
