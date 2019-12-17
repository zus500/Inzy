package com.example.demo.Configuration;

import com.example.demo.Class.Klient;
import com.example.demo.Service.ServiceKlient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KlientBean {

    @Bean
    public Klient klient (){
        return  new Klient();
    }

    @Bean
    public ServiceKlient klientservice (){
        return  new ServiceKlient();
    }
}
