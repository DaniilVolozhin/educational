package ru.education;

import io.reactivex.Observable;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class CreateExamples {

    public static void main(String[] args) {
        //синхронно создает и возвращает обсервабл для асинх работы
        var obs1 = Observable.just("one", "two", "three");
        obs1.forEach(System.out::println);


        Observable<String> obs = createExample();
        obs.forEach(System.out::println);
        obs.forEach(System.out::println);
    }
    
    public static Observable<String> justExample() {
        return Observable.just("one", "two", "three");
    }

    //обсурвабл вернется сразу. данные зададуться после
    public static Observable<String> createExample() {
        return Observable.create(emitter -> {
            if (emitter.isDisposed()) {
                return;
            }
            emitter.onNext("one");
            emitter.onNext("two");//!
            emitter.onNext("three");
            if (!emitter.isDisposed()) {
                emitter.onComplete();
            }
        });
    }

    //lazy создаение обсервабл, до момента подписки на него
    public static Observable<String> deferExample() {
        return Observable.defer(() -> Observable.just("one", "two", "three"));
    }
}
