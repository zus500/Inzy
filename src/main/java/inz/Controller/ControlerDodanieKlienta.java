package inz.Controller;


import inz.Class.Klient;
import inz.Class.Pracownik;
import inz.Service.ServiceKlient;
import inz.Service.ServicePracownik;
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

        return "redirect:/strona/klienci";
    }

}
