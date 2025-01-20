package ru.education.spring;

import io.reactivex.Flowable;
import io.reactivex.Single;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class RxJava2Controller {

    @GetMapping("/rx/one")
    public Single<String> single() {
        return Single.just("one");
    }

    @GetMapping("/rx/ten")
    public Flowable<Integer> list() {
        return Flowable.range(1, 10);
//        return Flowable.range(1, 10)
//                .delay(3, TimeUnit.SECONDS);
    }

    @GetMapping("/rx/five")
    public Flowable<Integer> listFive() {
        return list()
                .take(5)
                .delay(200, TimeUnit.MILLISECONDS);
    }
}
