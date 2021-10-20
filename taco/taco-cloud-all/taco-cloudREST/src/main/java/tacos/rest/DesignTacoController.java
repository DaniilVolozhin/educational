//package tacos.rest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.hateoas.Resources;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import tacos.entity.Taco;
//import tacos.entity.resource.TacoResource;
//import tacos.entity.resource.TacoResourceAssembler;
//import tacos.repository.IngredientRepository;
//import tacos.repository.TacoRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
//
//@RestController
//@RequestMapping(path = "/design", produces = {"application/json"}) // отдает только json
//@CrossOrigin(origins = "*") // позволяет перекресные запросы
//public class DesignTacoController {
//
//    private TacoRepository tacoRepo;
//
///*    @Autowired
//    private EntityLinks entityLinks;*/
//
//    @Autowired
//    public DesignTacoController(TacoRepository designRepo) {
//        this.tacoRepo = designRepo;
//    }
//
//    @GetMapping("/recent")  // формирует и одает последние заказы тако с сылками на сами и возвращает специальный объект через ассемблер
//    public Resources<TacoResource> recentTacos() {
//        PageRequest page = PageRequest.of(0, 12/*, Sort.by("createAt").descending()*/);
//        List<Taco> tacos = tacoRepo.findAll(page).getContent();
//        List<TacoResource> tacoResources = new TacoResourceAssembler().toResources(tacos);
//        Resources<TacoResource> recentResources = new Resources<TacoResource>(tacoResources);
//        recentResources.add(linkTo(methodOn(DesignTacoController.class).recentTacos()).withRel("recents"));
//        return recentResources;
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
//        Optional<Taco> optTaco = tacoRepo.findById(id);
//        if (optTaco.isPresent()) { // если нашли то вернули его и ок
//            return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // если не нашли вернули пустую страницу
//    }
//
//    @PostMapping(consumes = "application/json")
//    @ResponseStatus(HttpStatus.CREATED) // код ответа 201, произошло сооздание
//    public Taco postTaco(@RequestBody Taco taco) { // гарантия что тако связан с json, а не с формой или с представлением
//        return tacoRepo.save(taco);
//    }
//
//    /*    @GetMapping("/recent")  // формирует и одает последние заказы тако с сылками на сами и возвращает специальный объект
//    public Resources<Resource<Taco>> recentTacos() { // формирует и отдает последние заказы тако с сылками на сами тако
//        PageRequest page = PageRequest.of(0, 12, Sort.by("createAt").descending());
//        List<Taco> tacos = tacoRepo.findAll(page).getContent();
//        Resources<Resource<Taco>> recentResources = Resources.wrap(tacos);
//        //recentResources.add(new Link("http://localhost:8080/design/recent", "recents")); // добавить в json параметр recents c адресом
////        recentResources.add(linkTo(DesignTacoController.class).slash("recent").withRel("recents")); // делает тоже самое что и new Link только короче
//        recentResources.add(
//                linkTo(methodOn(DesignTacoController.class).recentTacos()) // вызывается метод recentTacos() у переданного класса и перехватывает url
//                        .withRel("recents")); // делает тоже самое что и new Link только короче
//        return recentResources;
//    }*/
//
///*    @GetMapping("/recent") // формирует и одает последние заказы тако
//    public Iterable<Taco> recentTacos() {
//        PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
//        return tacoRepo.findAll(page).getContent();
//    }*/
///*    @GetMapping("/recent") // формирует и отдает последние заказы тако с сылками на сами тако
//    public Resources<Resource<Taco>> recentTacos() {
//        PageRequest page = PageRequest.of(0, 12, Sort.by("createAt").descending());
//        List<Taco> tacos = tacoRepo.findAll(page).getContent();
//        Resources<Resource<Taco>> recentResources = Resources.wrap(tacos);
//        //recentResources.add(new Link("http://localhost:8080/design/recent", "recents")); // добавить в json параметр recents c адресом
////        recentResources.add(linkTo(DesignTacoController.class).slash("recent").withRel("recents")); // делает тоже самое что и new Link только короче
//        recentResources.add(
//                linkTo(methodOn(DesignTacoController.class).recentTacos()) // вызывается метод recentTacos() у переданного класса и перехватывает url
//                        .withRel("recents")); // делает тоже самое что и new Link только короче
//        return recentResources;
//    }*/
//
//}
