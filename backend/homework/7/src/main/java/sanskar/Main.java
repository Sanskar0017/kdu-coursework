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

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        Main main = context.getBean(Main.class);
        main.generateAndPrintVehicleDetails();
    }

    void generateAndPrintVehicleDetails() {
        vehicleFactory1.generatevehicles();
        vehicleFactory2.generatevehicles();

        // Most Expensive Vehicles
        Vehicle mostExpensiveVehicleFactory1 = vehicleFactory1.mostExpensive();
        Vehicle mostExpensiveVehicleFactory2 = vehicleFactory2.mostExpensive();

        logger.logInfo("Most Expensive Vehicle produced by Factory 1:");
        logger.logInfo("Price: " + mostExpensiveVehicleFactory1.getPrice() + ", Tyre: " + mostExpensiveVehicleFactory1.getTyre().getPrice() + ", Speaker: " + mostExpensiveVehicleFactory1.getSpeaker().getName());

        logger.logInfo("Most Expensive Vehicle produced by Factory 2:");
        logger.logInfo("Price: " + mostExpensiveVehicleFactory2.getPrice() + ", Tyre: " + mostExpensiveVehicleFactory2.getTyre().getPrice() + ", Speaker: " + mostExpensiveVehicleFactory2.getSpeaker().getName());


        Vehicle leastExpensiveVehicleFactory1 = vehicleFactory1.leastExpensive();
        Vehicle leastExpensiveVehicleFactory2 = vehicleFactory2.leastExpensive();

        logger.logInfo("Least Expensive Vehicle produced by Factory 1:");
        logger.logInfo("Price: " + leastExpensiveVehicleFactory1.getPrice() + ", Tyre: " + leastExpensiveVehicleFactory1.getTyre().getPrice() + ", Speaker: " + leastExpensiveVehicleFactory1.getSpeaker().getName());

        logger.logInfo("Least Expensive Vehicle produced by Factory 2:");
        logger.logInfo("Price: " + leastExpensiveVehicleFactory2.getPrice() + ", Tyre: " + leastExpensiveVehicleFactory2.getTyre().getPrice() + ", Speaker: " + leastExpensiveVehicleFactory2.getSpeaker().getName());
    }
}
