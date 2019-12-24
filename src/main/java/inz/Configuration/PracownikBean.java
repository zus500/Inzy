package inz.Configuration;

import inz.Class.Pracownik;
import inz.Service.ServicePracownik;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PracownikBean {

    @Bean
    public Pracownik pracownik ()
    {
        return new Pracownik();
    }
    @Bean
    public ServicePracownik pracownikserver ()
    {
        return new ServicePracownik();
    }
}
