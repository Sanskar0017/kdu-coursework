package sanskar.service;

import org.springframework.stereotype.Component;
import sanskar.logging.Logging;
import sanskar.model.Vehicle;

@Component
abstract class VehicleService {
    Logging logger=new Logging();
    public abstract void generateVehicles();
    public abstract Vehicle mostExpensive();
    public abstract Vehicle leastExpensive();
}