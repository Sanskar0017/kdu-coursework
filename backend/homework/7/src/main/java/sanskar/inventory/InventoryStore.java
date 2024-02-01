package sanskar.inventory;
import sanskar.model.Vehicle;

import java.util.ArrayList;
import java.util.List;
public class InventoryStore {
    private List<Vehicle> vehicles=new ArrayList<>();
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}