package demoFacultad.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import demoFacultad.models.ApiModels;

@Controller
@RequestMapping("/Api/capibaras")
public class ApiController {
    
    @GetMapping
    public String apicapibara(Model model) {
        CompletableFuture.supplyAsync(() -> {
            RestTemplate restTemplate = new RestTemplate();
            ApiModels apiModels = restTemplate.getForObject(
                    "https://api.capy.lol/v1/capyoftheday",
                    ApiModels.class);
            String imageUrl = apiModels.getImageUrl();
            model.addAttribute("imageUrl", imageUrl);
            return imageUrl;
        }).exceptionally(ex -> {
            model.addAttribute("imageUrl", null);
            return null;
        });
        return "capibaras";
    }
}
