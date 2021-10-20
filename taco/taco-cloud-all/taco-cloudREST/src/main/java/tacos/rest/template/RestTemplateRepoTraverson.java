package tacos.rest.template;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import tacos.entity.Ingredient;
import tacos.entity.Taco;

import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest")
public class RestTemplateRepoTraverson {

    private final String urlIngredientsId = "http://localhost:8080/ingredints/{id}";
    private final String urlIngredient = "http://localhost:8080/ingredints";
    private final String urlApi = "http://localhost:8080/api";

    @Autowired
    private RestTemplate restTempl;

    @Autowired
    private Traverson traverson;

    private ParameterizedTypeReference<Resources<Ingredient>> ingredientType =
        new ParameterizedTypeReference<Resources<Ingredient>>() {};
    Resources<Ingredient> ingredientRes = traverson.follow("ingredient").toObject(ingredientType);
    Collection<Ingredient> ingredients = ingredientRes.getContent(); // получает элементы с ссылками на себя

    private ParameterizedTypeReference<Resources<Taco>> ingredientTypeTaco =
            new ParameterizedTypeReference<Resources<Taco>>() {};
//    Resources<Taco> tacoRes = traverson.follow("tacos").follow("recents").toObject(ingredientTypeTaco);
    Resources<Taco> tacoRes = traverson.follow("tacos", "recents").toObject(ingredientTypeTaco);
    Collection<Taco> tacos = tacoRes.getContent(); // получает элементы с ссылками на себя

    public Ingredient addIngredient(Ingredient ingredient) {
        String ingredientsUrl = traverson.follow("ingredients").asLink().getHref(); // получаем ссылку на новосозданный элемент
        return restTempl.postForObject(ingredientsUrl, ingredient, Ingredient.class); // вернется новый тако
    }

    @Bean
    public Traverson traversons() {
        return new Traverson(URI.create(urlApi), MediaTypes.HAL_JSON); // гипер ссылки в стиле HAL_JSON
    }
}
