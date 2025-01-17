package ru.education.subject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class SubjectPublisher {
    public static void main(String[] args) throws Exception {
        publisherExample();
        System.in.read();
    }

    public static void publisherExample() throws Exception {
        final Observable<String> ob = subjectPublisher();
        System.out.println("First subscribed");
        ob.subscribe(System.out::println);
        Thread.sleep(5000);
        System.out.println("Second subscribed");
        ob.subscribe(System.out::println);
    }

//    PublishSubject позволяет добавить занчение в любой момент и опубликовать его
    public static Observable<String> subjectPublisher() {
        Random r = new Random(1);
        AtomicInteger i = new AtomicInteger();
        final Observable<String> obs = Observable.<String>generate(emitter ->
            emitter.onNext("" + i.incrementAndGet()))
            .concatMap(s -> Observable.just(s).delay(r.nextInt(1000), TimeUnit.MILLISECONDS))
            .subscribeOn(Schedulers.newThread());
        PublishSubject<String> subject = PublishSubject.create();
        obs.subscribe(subject);

        new Thread(() -> {
            try {
                Thread.sleep(2000L);
                subject.onNext("234");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        return subject;
    }
}
