package demoFacultad.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import demoFacultad.models.PlanetaModel;

@Controller
@RequestMapping("/Planetas")
public class PlanetaController {

    @GetMapping("{cl}")
    public String startMethod (@PathVariable("cl") String cl, Model model) {
        String titulo = "Pagina API con Spring Boot";
        model.addAttribute("name", cl);
        model.addAttribute("titulo", titulo);
        PlanetaModel inicioPlaneta = planetasDTO (cl);
        model.addAttribute("inicioPlaneta", inicioPlaneta);
        return "planetas";
    }
    
    public PlanetaModel planetasDTO (String numID) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PlanetaModel> resp =
                restTemplate
                .getForEntity(
                        String.format("https://myappfb-4718b.firebaseio.com/campeche/planetas/%s.json", numID),
                        PlanetaModel.class);
        return resp.getBody();
    
    
    }
}