package com.example.demo.Configuration;

import com.example.demo.Class.Sprawy;
import com.example.demo.Service.ServiceSprawy;
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
