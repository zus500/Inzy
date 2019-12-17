package com.example.demo.Controller;

import com.example.demo.Class.Klient;
import com.example.demo.RecordNotFoundException;
import com.example.demo.Service.ServiceKlient;
import com.example.demo.Service.ServicePracownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControlerKlienci {

    @Autowired
    ServiceKlient serviceKlient;

    @Autowired
    ServicePracownik servicePracownik;
    @RequestMapping(value = "/klienci")
    public String klienci(Model model) {

        model.addAttribute("kliencilista", serviceKlient.getAllKlient());

        return "klienci";

    }

    @RequestMapping(value = "/klienci/usun/{id}")
    public String usun (@PathVariable("id") Integer id) throws RecordNotFoundException {

        serviceKlient.deleteKlientById(id);

        return "redirect:/klienci";

    }
    @RequestMapping (value = "/klienci{id}" )
    public String edytuj (@PathVariable("id") Integer id , Model model ) throws RecordNotFoundException {

        Klient klient = serviceKlient.getKlientById(id);
        model.addAttribute("klients" , klient);
        model.addAttribute("user" , servicePracownik.getAllPracownik());
        return "dodanie_klienta";
    }
}
