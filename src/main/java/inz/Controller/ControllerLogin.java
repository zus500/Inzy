package inz.Controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerLogin {

    @RequestMapping(value = {"/login" , "/"})
    public String login (){
        return "logowanie";
    }

}
