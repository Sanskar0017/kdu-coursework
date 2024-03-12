package kdu.sanskar.springjpa.repository;

import kdu.sanskar.springjpa.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
/**
 * Repository interface for managing User entities.
 */
@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
    /**
     * Update user information.
     *
     * @param id       The unique identifier of the user.
     * @param userName The new username for the user.
     * @param loggedIn The login status of the user.
     * @param timeZone The time zone of the user.
     */
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE Users SET userName = :userName, loggedIn = :loggedIn, timeZone = :timeZone WHERE id = :id")
    void updateUser(@Param("id") UUID id, @Param("userName") String userName, @Param("loggedIn") int loggedIn, @Param("timeZone") String timeZone);

}
