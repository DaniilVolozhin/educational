package ru.education.subject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class PublishSubjectExample {
    public static void main(String[] args) throws Exception {
        publisherExample();
        System.in.read();
    }

    public static void publisherExample() throws Exception {
        final Observable<String> ob = behaviorSubject();
        System.out.println("First subscribed");
        ob.subscribe(System.out::println);
        Thread.sleep(5000);
        System.out.println("Second subscribed");
        ob.subscribe(System.out::println);
    }

//    BehaviorSubject подписчик полчит текущее значение даже если оно уже
//    было отправлено подписчику и не было опубликованно новое.
//    Можно получить текущее значение(не воспроизвел)
    public static Observable<String> behaviorSubject() {
        Random r = new Random(1);
        AtomicInteger i = new AtomicInteger();
        final Observable<String> obs = Observable.<String>generate(emitter ->
                emitter.onNext("" + i.incrementAndGet()))
                .concatMap(s -> Observable.just(s).delay(r.nextInt(1000), TimeUnit.MILLISECONDS))
                .subscribeOn(Schedulers.newThread());

        BehaviorSubject<String> subject = BehaviorSubject.create();
        obs.subscribe(subject);

        return subject;
    }
}
