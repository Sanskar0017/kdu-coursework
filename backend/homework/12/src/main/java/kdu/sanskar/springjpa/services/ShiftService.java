
package kdu.sanskar.springjpa.services;

import kdu.sanskar.springjpa.model.Shifts;
import kdu.sanskar.springjpa.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
/**
 * Service class for managing shifts.
 */
@Service
public class ShiftService {

    private final ShiftRepository shiftRepository;

    /**
     * Constructor for ShiftService.
     *
     * @param shiftRepository the ShiftRepository instance to be used
     */
    @Autowired
    public ShiftService(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }

    /**
     * Adds a new shift.
     *
     * @param shift the shift to add
     */
    @Transactional
    public void addShift(Shifts shift) {
        shiftRepository.save(shift);
    }

    /**
     * Finds the top 3 shifts within the specified start and end dates.
     *
     * @param startDate the start date
     * @param endDate the end date
     * @return a list of Shifts representing the top 3 shifts
     */
    public List<Shifts> findTop3Shifts(Date startDate, Date endDate) {
        return shiftRepository.findTop3Shifts(startDate, endDate);
    }
}
