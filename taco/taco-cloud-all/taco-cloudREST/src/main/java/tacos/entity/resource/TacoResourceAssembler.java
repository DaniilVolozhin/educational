//package tacos.entity.resource;
//
//import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
//import tacos.entity.Taco;
//import tacos.rest.DesignTacoController;
//
//public class TacoResourceAssembler extends ResourceAssemblerSupport<Taco, TacoResource> {
//    public TacoResourceAssembler() {
//        super(DesignTacoController.class, TacoResource.class); // указывается что определения пути url будет по DesignTacoController
//    }
//
//    @Override
//    protected TacoResource instantiateResource(Taco taco) { // переопределяется если у TacoResource нет конструктора по умолчанию
//        return new TacoResource(taco);
//    }
//
//    @Override
//    public TacoResource toResource(Taco taco) { // заполняет ссылками объект
//        return createResourceWithId(taco.getId(), taco);
//    }
//}
