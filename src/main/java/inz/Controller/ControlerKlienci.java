package inz.Controller;

import inz.Class.Klient;
import inz.RecordNotFoundException;
import inz.Service.ServiceKlient;
import inz.Service.ServicePracownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@RequestMapping(value = "/strona")
@Controller
public class ControlerKlienci {

    @Autowired
    ServiceKlient serviceKlient;

    @Autowired
    ServicePracownik servicePracownik;
    @RequestMapping(value = "/klienci", method = RequestMethod.GET)
    public String klienci(Model model)throws RecordNotFoundException {
        model.addAttribute("kliencilista", serviceKlient.getAllKlient());
        return "klienci";
    }

    @RequestMapping(value = "/klienci/usun/{id}" ,method = RequestMethod.POST)
    public String usun (@PathVariable("id") Integer id)throws RecordNotFoundException {
        serviceKlient.deleteKlientById(id);
        return "redirect:/klienci";
    }
    @RequestMapping (value = "/klienci{id}" , method = RequestMethod.POST)
    public String edytuj (@PathVariable("id") Integer id , Model model ) throws RecordNotFoundException {
        Klient klient = serviceKlient.getKlientById(id);
        model.addAttribute("klients" , klient);
        model.addAttribute("user" , servicePracownik.getAllPracownik());
        return "dodanie_klienta";
    }
}
