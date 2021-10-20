package tacos.rest.template;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import tacos.entity.Ingredient;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest")
public class RestTemplateRepo {

    private final String urlIngredientsId = "http://localhost:8080/ingredints/{id}";
    private final String urlIngredient = "http://localhost:8080/ingredints";
    @Autowired
    private RestTemplate restTempl;

    // get
    public Ingredient getIngredientById(String ingredientId) {
        ResponseEntity<Ingredient> respEntity =
                    restTempl.getForEntity(urlIngredientsId, Ingredient.class, ingredientId);
        log.info("Fetched time: " + respEntity.getHeaders().getDate());
        return respEntity.getBody();
    }

    // save
    public void updateIngredient(Ingredient ingredient) {
        restTempl.put(urlIngredientsId, ingredient, ingredient.getId());
    }

    //post
    public URI createIngredientAndReturnURI(Ingredient ingredient) {
        return restTempl.postForLocation(urlIngredient, ingredient); // вернется ссылка на новый ингредиент
    }

    // post
    public ResponseEntity<Ingredient> createIngredientAndReturn(Ingredient ingredient) {
        return restTempl.postForEntity(urlIngredient, ingredient, Ingredient.class); // uri и ingredient
    }

    //post
    public Ingredient createIngredient(Ingredient ingredient) {
        return restTempl.postForObject(urlIngredient, ingredient, Ingredient.class); //  вернет новый объект
    }

    // delete
    public void deleteIngredient(Ingredient ingredient) {
        restTempl.delete(urlIngredientsId, ingredient.getId());
    }

    public Ingredient getIngredientByIdWithMap(String ingredientId) {
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("id", ingredientId);
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/ingredints/{id}").build(urlVariables);
        return restTempl.getForObject(url, Ingredient.class);
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
