package sanskar.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import sanskar.model.Speaker;
@Configuration
public class SpeakerService {
    @Bean
    @Primary
    public Speaker getSonySpeaker(){
        return new Speaker("Sony",4400.0);
    }
    @Bean
    public Speaker getBoseSpeaker(){
        return new Speaker("Bose",5600.0);
    }


}
