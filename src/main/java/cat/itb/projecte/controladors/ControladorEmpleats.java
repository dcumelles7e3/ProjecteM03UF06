package cat.itb.projecte.controladors;

import cat.itb.projecte.model.entitats.Empleat;
import cat.itb.projecte.model.serveis.ServeiEmpleats;
import cat.itb.projecte.model.serveis.ServeiUsuaris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorEmpleats {
    @Autowired
    private ServeiEmpleats servei;

    @GetMapping("/empleats/list")
    public String llistar(Model m) {
        m.addAttribute("llistaEmpleats", servei.llistat());
        return "llistat";
    }

    @GetMapping("/empleats/new")
    public String afegirEmpleat(Model m) {
        m.addAttribute("empleatForm", new Empleat());
        return "afegir";
    }

    @PostMapping("empleats/new/submit")
    public String afegirSubmit(@ModelAttribute("empleatForm") Empleat emp) {
        servei.afegir(emp);
        return "redirect:/empleats/list";
    }

    @GetMapping("/empleats/eliminar")
    public String eliminarEmpleat(@RequestParam("id") int id) {
        servei.eliminarPerId(id);
        return "redirect:/empleats/list";
    }

    @PostMapping("/empleats/edit/submit")
    public String editarSubmit(@ModelAttribute("empleatForm") Empleat emp) {
        servei.substituir(emp);
        return "redirect:/empleats/list";
    }

    @GetMapping("/empleats/edit/{id}")
    public String editarEmpleat(@PathVariable("id") int id, Model m) {
        m.addAttribute("empleatForm", servei.consultaPerId(id));
        return "afegir";
    }

    @GetMapping("/empleats/listord")
    public String llistarOrdenat(Model m) {
        m.addAttribute("llistaEmpleats", servei.llistatOrdenatPerNom());
        return "llistat";
    }

    @GetMapping("/empleats/consultaid")
    public String consultaPerId(@RequestParam("id") int id, Model m) {
        m.addAttribute("llistaEmpleats", servei.consultaPerId(id));
        return "llistat";
    }
}
