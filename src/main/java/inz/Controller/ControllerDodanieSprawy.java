package inz.Controller;

import inz.Class.Sprawy;
import inz.Service.ServiceSprawy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        return  "redirect:/strona/sprawy";
    }



}
