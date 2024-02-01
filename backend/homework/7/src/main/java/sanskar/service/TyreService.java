package sanskar.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import sanskar.model.Tyre;
@Configuration

public class TyreService {

    @Bean("MRF")
    @Primary
    public Tyre generateMRFTyre(){
        return new Tyre("MRF",987584.0);
    }
    @Bean("Bridgestone")
    public Tyre generateBridgestoneTyre(){
        return new Tyre("Bridgestone",786564.0);
    }
}
