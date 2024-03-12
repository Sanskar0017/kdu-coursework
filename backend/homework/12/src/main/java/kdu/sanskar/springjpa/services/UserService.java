package kdu.sanskar.springjpa.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kdu.sanskar.springjpa.exceptions.RecordNotFoundException;
import kdu.sanskar.springjpa.model.Users;
import kdu.sanskar.springjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Add a new user.
     *
     * @param user The user to add.
     */
    public void addUser(Users user) {
        userRepository.save(user);
    }

    /**
     * Get all users with pagination.
     *
     * @param pageNumber The page number.
     * @param pageSize   The size of each page.
     * @return A page containing user data.
     */
    public Page<Users> getAllUsers(int pageNumber, int pageSize) {
        pageNumber = Math.max(0, pageNumber);
        pageSize = Math.min(50, Math.max(1, pageSize));

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return userRepository.findAll(pageable);
    }

    /**
     * Update a user's information.
     *
     * @param userID The ID of the user to update.
     * @param users  The updated user information.
     * @throws RecordNotFoundException If the user is not found.
     */
    public void updateUser(UUID userID, Users users) throws RecordNotFoundException {
        Users findUser = entityManager.find(Users.class, userID);

        if (findUser == null) {
            throw new RecordNotFoundException("User Not found for update");
        }

        userRepository.updateUser(users.getId(), users.getUserName(), users.getLoggedIn(), users.getTimeZone());
    }
}
