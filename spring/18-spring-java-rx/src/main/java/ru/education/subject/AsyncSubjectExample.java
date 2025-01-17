package ru.education.subject;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.PublishSubject;
import ru.education.pojo.Person;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class AsyncSubjectExample {
    public static void main(String[] args) throws Exception {
        publisherExample();
        System.in.read();
    }

    public static void publisherExample() throws Exception {
        final Observable<String> ob = asyncSubject();
        System.out.println("First subscribed");
        ob.subscribe(System.out::println);
        Thread.sleep(5000);
        System.out.println("Second subscribed");
        ob.subscribe(System.out::println);
    }

//    AsyncSubject аналог completableFuture, отправляет значение
//    пока не будет завершен методом onComplete()
    public static Observable<String> asyncSubject() {
        Random r = new Random(1);
        AtomicInteger i = new AtomicInteger();
        final Observable<String> obs = Observable.<String>generate(emitter ->
            emitter.onNext("" + i.incrementAndGet()))
            .concatMap(s -> Observable.just(s).delay(r.nextInt(1000), TimeUnit.MILLISECONDS))
            .subscribeOn(Schedulers.newThread());
        AsyncSubject<String> subject = AsyncSubject.create();
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            subject.onComplete();
        });

        obs.subscribe(subject);
        return subject;
    }

//Subject example
    public static Observable<String> subjectPublisher() {
        Random r = new Random(1);
        AtomicInteger i = new AtomicInteger();
        final Observable<String> obs = Observable.<String>generate(emitter ->
            emitter.onNext("" + i.incrementAndGet()))
            .concatMap(s -> Observable.just(s).delay(r.nextInt(1000), TimeUnit.MILLISECONDS))
            .subscribeOn(Schedulers.newThread());
        PublishSubject<String> subject = PublishSubject.create();
        obs.subscribe(subject);
        return subject;
    }

    //compose() Example
    private static ObservableTransformer<Person, String> filterAndUpperCase() {
        return upstream -> upstream
            .map(p -> p.getFirstName() + " " + p.getLastName());
    }
}
