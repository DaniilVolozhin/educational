package ru.education.example.applicationeventsdemo.events.listener;

import lombok.SneakyThrows;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.education.example.applicationeventsdemo.events.HalfAGlassOfWaterEvent;

@Component
public class ImplementationListenerNegativeRespondent implements ApplicationListener<HalfAGlassOfWaterEvent> {

    @SneakyThrows
    @Override
    public void onApplicationEvent(HalfAGlassOfWaterEvent halfAGlassOfWaterEvent) {
        Thread.sleep(100);
        System.out.println("Негативно настроенный слушатель");
        System.out.println(String.format("- %s", halfAGlassOfWaterEvent.getPayload()));
        System.out.println("- Какой ужас. Теперь он наполовину пуст!!!\n\n");
    }
}
