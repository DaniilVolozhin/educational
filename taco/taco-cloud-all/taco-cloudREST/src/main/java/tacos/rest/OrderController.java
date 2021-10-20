//package tacos.rest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//import tacos.entity.Order;
//import tacos.repository.OrderRepository;
//
//@RestController
//@RequestMapping(path = "/orders", produces = {"application/json"})
//@CrossOrigin(origins = "*")
//public class OrderController {
//
//    private OrderRepository orderRepo;
//
//    @Autowired
//    public OrderController(OrderRepository orderRepo) {
//        this.orderRepo = orderRepo;
//    }
//
//    @PostMapping(consumes = "application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Order postOrder(@RequestBody Order order) {
//        return orderRepo.save(order);
//    }
//
//    @PutMapping(value = "/{orderId}", consumes = "application/json") // типа апдейт всего заказа, если что то пусто, то будет изменено на пусто, не точечный апдейт
//    public Order putOrder(@RequestBody Order order) {
//        return orderRepo.save(order);
//    }
//
//    @PatchMapping(path = "/{orderId}", consumes = "application/json") // точечный апдейт
//    public Order patchOrder(@PathVariable("orderId") Long orderId, @RequestBody Order patch) { // PathVariable получает из url orderId
//        Order order = orderRepo.findById(orderId).get();
//        if (patch.getName() != null) {
//            order.setName(patch.getName());
//        }
//        if (patch.getStreet() != null) {
//            order.setStreet(patch.getStreet());
//        }
//        if (patch.getCity() != null) {
//            order.setCity(patch.getCity());
//        }
//        if (patch.getState() != null) {
//            order.setState(patch.getState());
//        }
//        if (patch.getZip() != null) {
//            order.setZip(patch.getZip());
//        }
//        if (patch.getCcNumber() != null) {
//            order.setCcNumber(patch.getCcNumber());
//        }
//        if (patch.getCcExpiration() != null) {
//            order.setCcExpiration(patch.getCcExpiration());
//        }
//        if (patch.getCcCVV() != null) {
//            order.setCcCVV(patch.getCcCVV());
//        }
//        return orderRepo.save(order);
//    }
//
//    @DeleteMapping("/{orderId}")
//    @ResponseStatus(code = HttpStatus.NO_CONTENT)
//    public void deleteOrder(@PathVariable("orderId") Long orderId) {
//        try {
//            orderRepo.deleteById(orderId);
//        } catch (EmptyResultDataAccessException e) {
//        }
//    }
//
//}
