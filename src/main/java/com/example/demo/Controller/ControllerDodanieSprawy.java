package com.example.demo.Controller;

import com.example.demo.Class.Klient;
import com.example.demo.Class.Sprawy;
import com.example.demo.Service.ServiceSprawy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerDodanieSprawy {
    @Autowired
    ServiceSprawy serviceSprawy;

    @RequestMapping(value = "/dodaniesprawy" , method = RequestMethod.GET)
    public String widok(Model model)
    {
        model.addAttribute("dodanie" , new Sprawy());
        return  "dodaj_sprawe";
    }

    @RequestMapping(value = "/dodawaniespraw" , method = RequestMethod.POST)
    public String zapisz(@ModelAttribute("id")Sprawy sprawy)
    {   System.out.print(sprawy);
        serviceSprawy.createOrUpdateSprawy(sprawy);
        return  "redirect:/sprawy";
    }



}
