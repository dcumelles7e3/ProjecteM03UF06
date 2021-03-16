package cat.itb.projecte.controladors;

import cat.itb.projecte.model.serveis.ServeiUsuaris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorLogin {
    @Autowired
    private ServeiUsuaris servei;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
