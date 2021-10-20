//package tacos.entity.resource;
//
//import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
//import tacos.rest.IngredientController;
//import tacos.entity.Ingredient;
//
//public class IngredientResourceAssembler extends ResourceAssemblerSupport<Ingredient, IngredientResource> {
//    public IngredientResourceAssembler() {
//        super(IngredientController.class, IngredientResource.class);
//    }
//
//    @Override
//    public IngredientResource toResource(Ingredient ingredient) { // заполняет ссылками объект
//        return createResourceWithId(ingredient.getId(), ingredient);
//    }
//
//    @Override
//    protected IngredientResource instantiateResource(Ingredient ingredient) { // переопределяется если у TacoResource нет конструктора по умолчанию
//        return new IngredientResource(ingredient);
//    }
//}
