package inz.Configuration;

import inz.Service.ServiceKlient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KlientBean {
    @Bean
    public ServiceKlient klientservice (){
        return  new ServiceKlient();
    }
}
