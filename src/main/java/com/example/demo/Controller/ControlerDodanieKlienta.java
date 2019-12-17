package com.example.demo.Controller;


import com.example.demo.Class.Klient;
import com.example.demo.Class.Pracownik;
import com.example.demo.Service.ServiceKlient;
import com.example.demo.Service.ServicePracownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ControlerDodanieKlienta {


    @Autowired
    ServicePracownik servicePracownik;

    @Autowired
    ServiceKlient serviceKlient;

    @RequestMapping(value = "/dodanie_klienta")
    public String klienci (Model model)
    {
        model.addAttribute("user" , servicePracownik.getAllPracownik());
        model.addAttribute("klients" , new Klient());
        return "dodanie_klienta";
    }

    @RequestMapping(value = "/klienci" , method = RequestMethod.POST)
    public String DodajKlienta (Klient klient , @ModelAttribute("idd") Pracownik pracownik ){

        klient.setPracownik(pracownik);
        serviceKlient.createOrUpdateKlient(klient);

        return "redirect:/klienci";
    }

}
