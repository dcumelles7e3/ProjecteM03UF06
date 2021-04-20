package cat.itb.projecte.controladors;

import cat.itb.projecte.model.entitats.Carta;
import cat.itb.projecte.model.serveis.ServeiCartes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorCartes {
    @Autowired
    private ServeiCartes servei;

    @GetMapping("/cartes/list")
    public String llistar(Model m) {
        m.addAttribute("llistaCartes", servei.llistat());
        return "llistat";
    }

    @GetMapping("/cartes/new")
    public String afegirCarta(Model m) {
        m.addAttribute("cartaForm", new Carta());
        return "afegir";
    }

    @PostMapping("cartes/new/submit")
    public String afegirSubmit(@ModelAttribute("cartaForm") Carta carta) {
        servei.afegir(carta);
        return "redirect:/cartes/list";
    }

    @GetMapping("/cartes/eliminar")
    public String eliminarCarta(@RequestParam("id") long id) {
        servei.eliminarPerId(id);
        return "redirect:/cartes/list";
    }

    @PostMapping("/cartes/edit/submit")
    public String editarSubmit(@ModelAttribute("cartaForm") Carta carta) {
        servei.substituir(carta);
        return "redirect:/cartes/list";
    }

    @GetMapping("/cartes/edit/{id}")
    public String editarCarta(@PathVariable("id") int id, Model m) {
        m.addAttribute("cartaForm", servei.findById(id));
        return "afegir";
    }

    @GetMapping("/cartes/consultaid")
    public String consultaPerId(@RequestParam("id") long id, Model m) {
        m.addAttribute("llistaCartes", servei.findById(id));
        return "llistat";
    }
}
