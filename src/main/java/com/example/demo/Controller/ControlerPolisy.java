package com.example.demo.Controller;

import com.example.demo.Class.Klient;
import com.example.demo.Class.Polisa;
import com.example.demo.RecordNotFoundException;
import com.example.demo.Service.ServicePolisa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControlerPolisy {

    @Autowired
    ServicePolisa servicePolisa;

    @RequestMapping(value = "/polisy")
    public String klienci (Model model)
    {
        model.addAttribute("polisy" , servicePolisa.getAllPolisa());
        return "polisy";
    }
    @RequestMapping (value = "/polisy/usun/{id}")
    public String usun (@PathVariable("id") Integer id) throws RecordNotFoundException {

        servicePolisa.deletePolisaById(id);
        return "redirect:/polisy";
    }
    @RequestMapping (value = "/polisy{id}")
    public String edytuj (@PathVariable("id") Integer id , Model model) throws RecordNotFoundException {

        Polisa polisa = servicePolisa.getPolisaById(id);
        Klient klient =  polisa.getKlient();

        model.addAttribute("polisa" , polisa);
        model.addAttribute("klient" , klient);
        return "dodanie_polisy";
    }

}
