package inz.Configuration;

import inz.Class.Polisa;
import inz.Service.ServicePolisa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PolisaBean {


    @Bean
    public Polisa polisa ()
    {
        return  new Polisa();
    }

    @Bean
    public ServicePolisa servicePolisa ()
    {
        return new ServicePolisa();
    }
}
