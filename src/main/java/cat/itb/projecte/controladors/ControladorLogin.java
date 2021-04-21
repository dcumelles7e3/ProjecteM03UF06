package cat.itb.projecte.controladors;

import cat.itb.projecte.model.entitats.Usuari;
import cat.itb.projecte.model.serveis.ServeiUsuaris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorLogin {
    @Autowired
    private ServeiUsuaris servei;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/registre")
    public String afegirUsuari(Model m) {
        m.addAttribute("userForm", new Usuari());
        return "registre";
    }

    @PostMapping("/registre")
    public String afegirSubmit(@ModelAttribute Usuari user) {
        servei.afegir(user);
        return "redirect:/login";
    }

}
