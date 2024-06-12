package sanskar.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sanskar.model.Speaker;
@Service
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
