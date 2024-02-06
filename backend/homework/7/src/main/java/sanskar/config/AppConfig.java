package sanskar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import sanskar.Main;
import sanskar.inventory.InventoryStore;
import sanskar.service.VehicleServiceFactory1;
import sanskar.service.VehicleServiceFactory2;

@Configuration
@ComponentScan("sanskar.service")
public class AppConfig {

    @Bean
    @Scope("prototype")
    public InventoryStore inventoryStore() {
        return new InventoryStore();
    }

    @Bean("vehicleServiceFactory1")
    public VehicleServiceFactory1 vehicleServiceFactory1() {
        return new VehicleServiceFactory1(inventoryStore());
    }

    @Bean("vehicleServiceFactory2")
    public VehicleServiceFactory2 vehicleServiceFactory2() {
        return new VehicleServiceFactory2(inventoryStore());
    }

    @Bean("main")
    public Main main() {
        return new Main();
    }
}
