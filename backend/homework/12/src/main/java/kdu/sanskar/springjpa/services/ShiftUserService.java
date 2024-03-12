package kdu.sanskar.springjpa.services;

import kdu.sanskar.springjpa.exceptions.RecordNotFoundException;
import kdu.sanskar.springjpa.model.ShiftUsers;
import kdu.sanskar.springjpa.repository.ShiftUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.UUID;

/**
 * Service class for managing shift users.
 */
@Service
@Transactional
public class ShiftUserService {

    private final ShiftUserRepository shiftUserRepository;

    /**
     * Constructs a new ShiftUserService with the provided ShiftUserRepository.
     *
     * @param shiftUserRepository The ShiftUserRepository used for database operations.
     */
    @Autowired
    public ShiftUserService(ShiftUserRepository shiftUserRepository) {
        this.shiftUserRepository = shiftUserRepository;
    }

    /**
     * Adds a new shift user.
     *
     * @param shiftUser The shift user DTO to be added.
     */
    public void addShiftUser(ShiftUsers shiftUser) {
        shiftUserRepository.save(shiftUser);
    }

    /**
     * Deletes a shift user by shift user ID.
     *
     * @param shiftUserId The ID of the shift user to be deleted.
     * @throws RecordNotFoundException if the shift user with the specified ID is not found.
     */
    public void deleteShiftUser(UUID shiftUserId) throws RecordNotFoundException {
        ShiftUsers shiftUsers = shiftUserRepository.findById(shiftUserId).orElse(null);

        if (shiftUsers != null && shiftUsers.getShifts().getEndTime().equals(Time.valueOf("23:00:00"))) {
            shiftUserRepository.delete(shiftUsers);
        } else {
            throw new RecordNotFoundException("No user with Shift time ending at 23:00 UTC");
        }
    }
}
