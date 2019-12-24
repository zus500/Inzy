package inz.Controller;

import inz.Class.Sprawy;
import inz.RecordNotFoundException;
import inz.Service.ServiceSprawy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControlerSprawy {

    @Autowired
    ServiceSprawy serviceSprawy;

    @RequestMapping(value = "/sprawy")
    public String widok(Model model){

        model.addAttribute("sprawy" , serviceSprawy.getAllSprawy());
        return "sprawy";
    }


    @RequestMapping (value = "/sprawy/usun/{id}")
    public String usun (@PathVariable("id") Integer id) throws RecordNotFoundException {

        serviceSprawy.deleteSprawyaById(id);
        return "redirect:/sprawy";
    }
    @RequestMapping (value = "/sprawy{id}")
    public String edytuj (@PathVariable("id") Integer id, Model model) throws RecordNotFoundException {

        Sprawy sprawy = serviceSprawy.getSprawyById(id);
        model.addAttribute("dodanie" , sprawy);
        return "dodaj_sprawe";
    }
}
