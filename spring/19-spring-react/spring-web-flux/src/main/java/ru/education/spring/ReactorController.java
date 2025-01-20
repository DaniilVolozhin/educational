package ru.education.spring;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class ReactorController {

    @GetMapping("/flux/one")
    public Mono<String> one() {
        return Mono.just("one");
    }

    @GetMapping("/flux/ten")
    public Flux<Integer> list() {
        return Flux.range(1, 10);
    }

    @GetMapping("flux/three")
    public Flux<Integer> three() {
        return list()
                .filter(elem -> elem % 3 == 1)
                .take(3)
                .map(elem -> elem * 100);
    }

    @GetMapping(path = "/flux/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> stream() {
        return Flux.generate(() -> 0, (state, emitter) -> {
            emitter.next(state);
            return state + 1;
        })
                .delayElements(Duration.ofSeconds(1L))
                .map(Object::toString);
    }
}
