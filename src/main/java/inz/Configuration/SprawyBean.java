package inz.Configuration;

import inz.Class.Sprawy;
import inz.Service.ServiceSprawy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SprawyBean {

    @Bean
    public Sprawy sprawy ()
    {
        return new Sprawy();
    }


    @Bean
    public ServiceSprawy serviceSprawy(){
        return new ServiceSprawy();
    }
}
