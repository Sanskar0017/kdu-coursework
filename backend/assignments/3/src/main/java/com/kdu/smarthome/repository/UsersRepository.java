package com.kdu.smarthome.repository;

import com.kdu.smarthome.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    @Query
    Users findByUsername(String userName);
}
