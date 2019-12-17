package com.example.demo.Controller;

import com.example.demo.Class.Klient;
import com.example.demo.Class.Polisa;
import com.example.demo.RecordNotFoundException;
import com.example.demo.Service.ServiceKlient;
import com.example.demo.Service.ServicePolisa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerDodaniePolisy {

    @Autowired
    ServiceKlient serviceKlient;

    @Autowired
    ServicePolisa servicePolisa;

    @RequestMapping(value = "/dodajpolise{id}")
    public String  dodaj (@PathVariable("id") Integer id, Model model ) throws RecordNotFoundException {

      model.addAttribute("klient" ,serviceKlient.getKlientById(id) );
      model.addAttribute("polisa" , new Polisa());

        return "dodanie_polisy";
    }

    @RequestMapping(value = "/dodajpolise")
    public String  zapisz (@ModelAttribute("idd") Klient klient, Polisa polisa ) {

        polisa.setKlient(klient);
        servicePolisa.createOrUpdatePolisa(polisa);
        return "redirect:/polisy";
    }
}
