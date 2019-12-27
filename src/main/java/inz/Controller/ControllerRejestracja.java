package inz.Controller;

import inz.Class.Pracownik;
import inz.Service.ServicePracownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ControllerRejestracja {

    @Autowired
    ServicePracownik servicePracownik;

    @RequestMapping(value = "/rejestracja" , method = RequestMethod.GET)
    public  String rejstracja (Model model){
        model.addAttribute("pracownik" , new Pracownik());
        return "rejestracja";
    }

    @RequestMapping(value = "/rejestracja" , method = RequestMethod.POST)
    public  ModelAndView stworzpracownika (@Valid Pracownik pracownik , BindingResult bindingResult ){

        ModelAndView modelAndView = new ModelAndView();
        Pracownik pracownik1 = servicePracownik.findByEmail(pracownik.getEmail());

        if(pracownik1 != null) bindingResult.rejectValue("email" , "blad.pracownik", "Taki email juz istnieje");

        if(bindingResult.hasErrors()){
            modelAndView.setViewName("rejestracja");
        }
        else {
            modelAndView.addObject("sukces", "Udało się zarejestrować");
            modelAndView.addObject("user", new Pracownik());
            modelAndView.setViewName("rejestracja");
        }
        return modelAndView;
    }
}
