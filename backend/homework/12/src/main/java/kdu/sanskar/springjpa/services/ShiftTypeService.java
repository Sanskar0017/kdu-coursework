package kdu.sanskar.springjpa.services;

import kdu.sanskar.springjpa.model.ShiftTypes;
import kdu.sanskar.springjpa.repository.ShiftTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for managing Shift Types.
 */
@Service
public class ShiftTypeService {

    private final ShiftTypeRepository shiftTypeRepository;

    @Autowired
    public ShiftTypeService(ShiftTypeRepository shiftTypeRepository) {
        this.shiftTypeRepository = shiftTypeRepository;
    }

    /**
     * Add a new Shift Type.
     * @param shift The Shift Type DTO to be added.
     */
    @Transactional
    public void addShiftTypeService(ShiftTypes shift) {
        shiftTypeRepository.save(shift);
    }
}
