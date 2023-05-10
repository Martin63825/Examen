package demoFacultad.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.ui.Model;

import demoFacultad.models.TramiteModel;

@Controller
@RequestMapping("/Tramites")
public class TramiteController {
    @GetMapping("{tr}")
    public String startMethod (@PathVariable("tr") String tr, Model model) {
        String titulo = "Pagina API con Spring Boot";
        model.addAttribute("name", tr);
        model.addAttribute("titulo", titulo);
        TramiteModel consultaTramites = tramites (tr);
        model.addAttribute("consultaTramites", consultaTramites);
        return "Tramites";
    }
    
    public TramiteModel tramites (String numID) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TramiteModel> resp =
                restTemplate
                .getForEntity(
                        String.format("https://myappfb-4718b.firebaseio.com/campeche/tramites/%s.json", numID),
                        TramiteModel.class);
        return resp.getBody();
    
    
    }
}