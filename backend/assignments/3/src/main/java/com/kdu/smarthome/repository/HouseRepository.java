package com.kdu.smarthome.repository;


import com.kdu.smarthome.models.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {
}
