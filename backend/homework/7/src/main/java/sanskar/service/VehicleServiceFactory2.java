package sanskar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import sanskar.inventory.InventoryStore;
import sanskar.model.Speaker;
import sanskar.model.Tyre;
import sanskar.model.Vehicle;

import java.util.Comparator;

public class VehicleServiceFactory2 extends VehicleService {

    @Autowired
    private TyreService tyreService;

    @Autowired
    private SpeakerService speakerService;

    private final InventoryStore inventoryStore;

    @Autowired
    public VehicleServiceFactory2(@Qualifier("InventoryStoreFactory1") InventoryStore inventoryStore) {
        this.inventoryStore = inventoryStore;
    }

    private Vehicle createRandomVehicle(boolean flag) {
        Tyre tyre = flag ? tyreService.generateBridgestoneTyre() : tyreService.generateMRFTyre();
        Speaker speaker = flag ? speakerService.getSonySpeaker() : speakerService.getBoseSpeaker();
        double price = 1.15 * Math.random() * 100000 + tyre.getPrice() + speaker.getPrice();
        return new Vehicle(tyre, speaker, price);
    }

    @Override
    public void generateVehicles() {
        for (int i = 0; i < 100; i++) {
            boolean flag = i % 2 == 0;
            inventoryStore.getVehicles().add(createRandomVehicle(flag));
        }

        inventoryStore.getVehicles().forEach(v -> logger.logInfo(v.getPrice() + " " + v.getSpeaker().getName() + " " + v.getTyre().getPrice()));
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
