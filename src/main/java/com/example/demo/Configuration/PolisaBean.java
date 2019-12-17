package com.example.demo.Configuration;

import com.example.demo.Class.Polisa;
import com.example.demo.Service.ServicePolisa;
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
