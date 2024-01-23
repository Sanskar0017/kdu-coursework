package sanskar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sanskar.config.AppConfig;
import sanskar.logging.Logging;
import sanskar.model.Vehicle;
import sanskar.service.VehicleServiceFactory1;
import sanskar.service.VehicleServiceFactory2;

public class Main {

    @Autowired
    @Qualifier("vehicleServiceFactory1")
    private VehicleServiceFactory1 vehicleFactory1;

    @Autowired
    @Qualifier("vehicleServiceFactory2")
    private VehicleServiceFactory2 vehicleFactory2;

    private static Logging logger = new Logging();

    private static final String TYRE_LABEL = ", Tyre: ";
    private static final String SPEAKER_LABEL = ", Speaker: ";
    private static final String PRICE_LABEL = "Price: ";

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        Main main = context.getBean(Main.class);
        main.generateAndPrintVehicleDetails();
    }

    void generateAndPrintVehicleDetails() {
        vehicleFactory1.generateVehicles();
        vehicleFactory2.generateVehicles();

        // Most Expensive Vehicles
        Vehicle mostExpensiveVehicleFactory1 = vehicleFactory1.mostExpensive();
        Vehicle mostExpensiveVehicleFactory2 = vehicleFactory2.mostExpensive();

        logger.logInfo("Most Expensive Vehicle produced by Factory 1:");
        logger.logInfo(PRICE_LABEL + mostExpensiveVehicleFactory1.getPrice() +
                TYRE_LABEL + mostExpensiveVehicleFactory1.getTyre().getPrice() +
                SPEAKER_LABEL + mostExpensiveVehicleFactory1.getSpeaker().getName());

        logger.logInfo("Most Expensive Vehicle produced by Factory 2:");
        logger.logInfo(PRICE_LABEL + mostExpensiveVehicleFactory2.getPrice() +
                TYRE_LABEL + mostExpensiveVehicleFactory2.getTyre().getPrice() +
                SPEAKER_LABEL + mostExpensiveVehicleFactory2.getSpeaker().getName());

        // Least Expensive Vehicles
        Vehicle leastExpensiveVehicleFactory1 = vehicleFactory1.leastExpensive();
        Vehicle leastExpensiveVehicleFactory2 = vehicleFactory2.leastExpensive();

        logger.logInfo("Least Expensive Vehicle produced by Factory 1:");
        logger.logInfo(PRICE_LABEL + leastExpensiveVehicleFactory1.getPrice() +
                TYRE_LABEL + leastExpensiveVehicleFactory1.getTyre().getPrice() +
                SPEAKER_LABEL + leastExpensiveVehicleFactory1.getSpeaker().getName());

        logger.logInfo("Least Expensive Vehicle produced by Factory 2:");
        logger.logInfo(PRICE_LABEL + leastExpensiveVehicleFactory2.getPrice() +
                TYRE_LABEL + leastExpensiveVehicleFactory2.getTyre().getPrice() +
                SPEAKER_LABEL + leastExpensiveVehicleFactory2.getSpeaker().getName());
    }
}
