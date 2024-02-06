package sanskar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sanskar.inventory.InventoryStore;
import sanskar.model.Vehicle;

import java.util.Comparator;

@Service
public class VehicleServiceFactory1 extends VehicleService {

    @Autowired
    private TyreService tyreService;

    @Autowired
    private SpeakerService speakerService;

    private final InventoryStore inventoryStore;

    @Autowired
    public VehicleServiceFactory1(InventoryStore inventoryStore) {
        this.inventoryStore = inventoryStore;
    }

    @Override
    public void generateVehicles() {
        boolean flag = true;
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                if (flag) {
                    inventoryStore.getVehicles().add(new Vehicle(tyreService.generateBridgestoneTyre(), speakerService.getSonySpeaker(), 1.1 * Math.random() * 100000 + tyreService.generateBridgestoneTyre().getPrice() + speakerService.getSonySpeaker().getPrice()));
                } else {
                    inventoryStore.getVehicles().add(new Vehicle(tyreService.generateBridgestoneTyre(), speakerService.getBoseSpeaker(), 1.1 * Math.random() * 100000 + tyreService.generateBridgestoneTyre().getPrice() + speakerService.getBoseSpeaker().getPrice()));
                }
                flag = !flag;
            } else {
                if (flag) {
                    inventoryStore.getVehicles().add(new Vehicle(tyreService.generateMRFTyre(), speakerService.getSonySpeaker(), 1.1 * Math.random() * 100000 + tyreService.generateMRFTyre().getPrice() + speakerService.getSonySpeaker().getPrice()));
                } else {
                    inventoryStore.getVehicles().add(new Vehicle(tyreService.generateMRFTyre(), speakerService.getBoseSpeaker(), 1.1 * Math.random() * 100000 + tyreService.generateMRFTyre().getPrice() + speakerService.getBoseSpeaker().getPrice()));
                }
            }
        }
        for (Vehicle v : inventoryStore.getVehicles()) {
            logger.logInfo(v.getPrice() + " " + v.getSpeaker().getName() + " " + v.getTyre().getPrice());
        }
    }

    @Override
    public Vehicle mostExpensive() {
        return inventoryStore.getVehicles().stream()
                .max(Comparator.comparingDouble(Vehicle::getPrice))
                .orElse(null);
    }

    @Override
    public Vehicle leastExpensive() {
        return inventoryStore.getVehicles().stream()
                .min(Comparator.comparingDouble(Vehicle::getPrice))
                .orElse(null);
    }
}
