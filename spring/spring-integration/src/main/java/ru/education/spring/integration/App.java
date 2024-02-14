package ru.education.spring.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.*;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@IntegrationComponentScan
public class App {

    public static void main( String[] args ) throws InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run( App.class, args );

        PollableChannel pollableChannel = ctx.getBean("pollableChannel", PollableChannel.class );
        SubscribableChannel subscribableChannel = ctx.getBean( "subscribableChannel", SubscribableChannel.class );

        subscribableChannel.subscribe( new MyMessageHandler(1) );
        subscribableChannel.subscribe( new MyMessageHandler(2) );
        subscribableChannel.subscribe( new MyMessageHandler(3) );
        subscribableChannel.subscribe( new MyMessageHandler(4) );
        subscribableChannel.subscribe( new MyMessageHandler(5) );
        subscribableChannel.subscribe( new MyMessageHandler(6) );
        subscribableChannel.subscribe( new MyMessageHandler(7) );

        thread(pollableChannel, subscribableChannel);

        pollableChannel.send( MessageBuilder.withPayload( "Hello" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );
        pollableChannel.send( MessageBuilder.withPayload( "Hello2" ).build() );

        Thread.sleep( 2000 );

        pollableChannel.send( MessageBuilder.withPayload( "Hello3" ).build() );

        Thread.sleep( 100000 );
    }

    private static void thread(PollableChannel pollableChannel, SubscribableChannel subscribableChannel) {
        new Thread( () -> {
            sleep(100);
            while ( true ) {
                System.out.println("before receive");
                System.out.println("before message");
                Message<?> receive = pollableChannel.receive();
                System.out.println("after message");
                System.out.println("before send");
                subscribableChannel.send(receive);
                System.out.println("after send");
                System.out.println("after receive");
            }
        } ).start();
    }

    private static void sleep(long time) {
        try {
            System.out.println("I sleep");
            Thread.sleep(time);
            System.out.println("after sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public PollableChannel pollableChannel() {
        return new QueueChannel( 100 );
    }

    @Bean
    public SubscribableChannel subscribableChannel() {
        return MessageChannels.publishSubscribe( "subscribableChannel" ).get();
    }

    static class MyMessageHandler implements MessageHandler {

        private int i;
        public MyMessageHandler(int i) {
            this.i = i;
        }

        @Override
        public void handleMessage(Message<?> message) throws MessagingException {
            System.out.println("My msg hendler " + i + " : " + message);
        }
    }
}
