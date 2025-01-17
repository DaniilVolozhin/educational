package ru.education.subject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class ReplaySubjectExample {
    public static void main(String[] args) throws Exception {
        publisherExample();
        System.in.read();
    }

    public static void publisherExample() throws Exception {
        final Observable<String> ob = replaySubject();
        System.out.println("First subscribed");
        ob.subscribe(System.out::println);
        Thread.sleep(5000);
        System.out.println("Second subscribed");
        ob.subscribe(System.out::println);
    }

    //    ReplaySubject сохраняет внутри себя все данные
//    при новом подписчике вернет все данные
//    пример горячего в холодный
    public static Observable<String> replaySubject() {
        Random r = new Random(1);
        AtomicInteger i = new AtomicInteger();
        final Observable<String> obs = Observable.<String>generate(emitter ->
                emitter.onNext("" + i.incrementAndGet()))
                .concatMap(s -> Observable.just(s).delay(r.nextInt(1000), TimeUnit.MILLISECONDS))
                .subscribeOn(Schedulers.newThread());

        ReplaySubject<String> subject = ReplaySubject.create();
        obs.subscribe(subject);
        return subject;
    }

}