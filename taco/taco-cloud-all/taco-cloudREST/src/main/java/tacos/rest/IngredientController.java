//package tacos.rest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.hateoas.Resource;
//import org.springframework.hateoas.Resources;
//import org.springframework.web.bind.annotation.*;
//import tacos.entity.Ingredient;
//import tacos.entity.Taco;
//import tacos.entity.resource.IngredientResource;
//import tacos.entity.resource.IngredientResource;
//import tacos.entity.resource.IngredientResourceAssembler;
//import tacos.entity.resource.TacoResourceAssembler;
//import tacos.repository.IngredientRepository;
//
//import java.util.List;
//
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
//
//@RestController
//@RequestMapping(path="/ingredients", produces="application/json")
//@CrossOrigin(origins="*")
//public class IngredientController {
//
//    private IngredientRepository ingredientRepo;
//
//    @Autowired
//    public IngredientController(IngredientRepository repo) {
//        this.ingredientRepo = repo;
//    }
//
//    @GetMapping("/{id}")
//    public Ingredient findById(@PathVariable String id) {
//        return ingredientRepo.findIngredientById(id);
//    }
//
//    @GetMapping("/recent")
//    public Resources<IngredientResource> allIngredients() {
//        PageRequest page = PageRequest.of(0, 12);
//        List<Ingredient> ingredients = ingredientRepo.findAll(page).getContent();
//        List<IngredientResource> ingredientResources = new IngredientResourceAssembler().toResources(ingredients);
//        Resources<IngredientResource> recentResources = new Resources<IngredientResource>(ingredientResources);
//        recentResources.add(linkTo(methodOn(IngredientController.class).allIngredients()).withRel("link"));
//        return recentResources;
//    }
//
//}
