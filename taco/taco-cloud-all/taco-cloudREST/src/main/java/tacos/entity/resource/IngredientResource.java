package tacos.entity.resource;

import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;
import tacos.entity.Ingredient;
import tacos.entity.Ingredient.Type;

public class IngredientResource extends ResourceSupport {

    @Getter
    private String name;

    @Getter
    private Type type;

    public IngredientResource(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }
}
