package cl.ipss.crud001s70.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.ipss.crud001s70.models.Persona;
import cl.ipss.crud001s70.services.PersonaService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    //Listar Personas

    @GetMapping
    public String listarPersonas(Model model) {
        model.addAttribute("personas", personaService.listarTodas());
        return "persona-listar";
    }
    
    //Nueva Persona

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevaPersona(Model model) {
        model.addAttribute("persona", new Persona());
        return "persona-crear";
    }

    //Guardar Persona

    @PostMapping("/guardar")
    public String guardarPersona(@Valid Persona persona) {
        personaService.guardar(persona);
        return "redirect:/";
    }
    //Editar Persona

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPersona(@PathVariable Long id, Model model) {
        model.addAttribute("persona", personaService.obtenerPorId(id));
        return "persona-crear";
    }

    //Eliminar Persona

    @GetMapping("/eliminar/{id}")
    public String mostrarFormularioNuevaPersona(@PathVariable Long id) {
        personaService.eliminar(id);
        return "redirect:/";

}

}
