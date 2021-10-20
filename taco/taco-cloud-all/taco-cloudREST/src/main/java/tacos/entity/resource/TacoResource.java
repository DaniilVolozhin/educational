//package tacos.entity.resource;
//
//import lombok.Getter;
//import org.springframework.hateoas.ResourceSupport;
//import tacos.entity.Taco;
//
//import java.util.Date;
//import java.util.List;
//
//public class TacoResource extends ResourceSupport {
//
//    private static final IngredientResourceAssembler ingredientAssembler = new IngredientResourceAssembler();
//
//    @Getter
//    private final String name;
//
//    @Getter
//    private final Date createAt;
//
//    @Getter
//    private final List<IngredientResource> ingredients;
//
//    public TacoResource(Taco taco) {
//        this.name = taco.getName();
//        this.createAt = taco.getCreatedAt();
//        this.ingredients = ingredientAssembler.toResources(taco.getIngredients());
//    }
//}
