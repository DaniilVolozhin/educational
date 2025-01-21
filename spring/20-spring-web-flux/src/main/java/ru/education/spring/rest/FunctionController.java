package ru.education.spring.rest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import ru.education.spring.domain.Person;
import ru.education.spring.repository.PersonRepository;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.queryParam;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class FunctionController {

    @Bean
    public RouterFunction<ServerResponse> composedRoutes(PersonRepository repository) {

        PersonHandler handler = new PersonHandler(repository);

        RouterFunction<ServerResponse> route = route()
                .GET("/func/person", accept(APPLICATION_JSON), handler::list)
                .GET("/func/person/{id}", accept(APPLICATION_JSON),
                        request -> repository.findById(request.pathVariable("id"))
                                .flatMap(person -> ok().contentType(APPLICATION_JSON).body(fromObject(person)))
                )
                .GET("/func/person/age/{age}", accept(APPLICATION_JSON),
                        serverRequest -> ok().contentType(APPLICATION_JSON)
                                .body(repository.findAllByAge(Integer.parseInt(serverRequest.pathVariable("age"))), Person.class))
                .GET("/func/person/find", accept(APPLICATION_JSON),
                        serverRequest -> ok().contentType(APPLICATION_JSON)
                                .body(repository.findAllByAge(Integer.parseInt(serverRequest.queryParam("age").get())), Person.class))
                .build();

        return route;
    }

    @Bean
    public RouterFunction<ServerResponse> findAgeOrLastName(PersonRepository repository) {
        PersonHandler handler = new PersonHandler(repository);

        return route()
                .GET("/func/person", accept(APPLICATION_JSON), handler::listAge)
                .GET("/func/person", queryParam("lastName", StringUtils::isNotEmpty),
                        request ->
                                ok().body(repository.findAllByLastName(request.pathVariable("lastName")), Person.class))
                .build();
    }

    static class PersonHandler {

        private PersonRepository repository;

        PersonHandler(PersonRepository repository) {
            this.repository = repository;
        }

        Mono<ServerResponse> list(ServerRequest request) {
            return ok().contentType(APPLICATION_JSON).body(repository.findAll(), Person.class);
        }

        Mono<ServerResponse> listAge(ServerRequest request) {
            System.out.println("I'm here");
            return ok().contentType(APPLICATION_JSON)
                    .body(repository.findAllByAge(Integer.parseInt(request.queryParam("age").get())), Person.class);
        }
    }
}
