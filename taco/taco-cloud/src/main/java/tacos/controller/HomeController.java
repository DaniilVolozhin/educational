package tacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.repository.IngredientRepository;

@Controller
@RequestMapping("/")
public class HomeController {

    private IngredientRepository ingredientRepository;

    @Autowired
    public HomeController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping
    public String fForm(Model model) {
        return "home";
    }
}
