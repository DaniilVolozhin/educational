package ru.education.spring.integration;

import org.junit.jupiter.api.Test;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SuppressWarnings("all")
public class MessagesTest {

    @Test
    public void testCreateSimpleGenericMessage() {
        //Создайте сообщение с payload-ом "Hello" с помощью конструктора
        Message<String> message =
                new GenericMessage("Hello");
//        MessageBuilder.withPayload("Hello").build();
        MessageBuilder.withPayload("test1")
                .setHeader("header1", "value1")
                .setHeaderIfAbsent("header2", "value2");

        MessageBuilder.withPayload("test2")
                .copyHeaders(message.getHeaders());

        MessageBuilder.fromMessage(message);

        assertNotNull(message);
        assertEquals(GenericMessage.class, message.getClass());
        assertNotNull(message.getPayload());
        assertEquals("Hello", message.getPayload());
    }

    @Test
    public void testCreateGenericMessage() {
        //Создайте сообщение с пользователем с помощью конструктора
        Message<User> message =
                new GenericMessage(new User("John", 23));
//                MessageBuilder.withPayload(new User("John", 23)).build();

        assertNotNull(message);
        assertEquals(GenericMessage.class, message.getClass());
        assertNotNull(message.getPayload());
        assertEquals(new User("John", 23), message.getPayload());
    }

    @Test
    public void testGenericMessageWithHeaders() {
        //Создайте сообщение с payload-ом "Hello" и header-ом "to":"World"
        Map<String, Object> headers = Map.of("to", "World");
        Message<String> message =
                new GenericMessage("Hello", headers);
//                MessageBuilder.withPayload("Hello")
//                        .copyHeaders(headers)
//                        .build();

        assertNotNull(message);
        assertEquals("Hello", message.getPayload());
        assertEquals("World", message.getHeaders().get("to", String.class));
    }

    @Test
    public void testGenericMessageWithMessageHeaders() {
        //Создайте сообщение с payload-ом "Hello" и header-ом "to":"World"
        MessageHeaders headers = new MessageHeaders(Map.of("to", "World"));
        Message<String> message =
                new GenericMessage<>("Hello", headers);
//                MessageBuilder.createMessage("Hello", headers);

        assertNotNull(message);
        assertEquals("Hello", message.getPayload());
        assertEquals("World", message.getHeaders().get("to", String.class));
    }

    @Test
    public void testErrorMessage() {
        //Создайте сообщение об ошибки с объектом NullPointerException внутри
        Message errorMessage =
                new ErrorMessage(new NullPointerException());
//                MessageBuilder.withPayload(new NullPointerException())
//                        .build();

        assertNotNull(errorMessage);
        assertEquals(ErrorMessage.class, errorMessage.getClass());
        assertEquals(NullPointerException.class, errorMessage.getPayload().getClass());
    }

    @Test
    public void testMessageBuilder() {
        //Создайте сообщение с payload-ом "Hello" и header-ом "to":"World" с помощью MessageBuilder
        Message message =
                MessageBuilder.withPayload("Hello")
                .setHeader("to", "World")
                .build();

        assertNotNull(message);
        assertEquals("Hello", message.getPayload());
        assertEquals("World", message.getHeaders().get("to", String.class));
    }

    @Test
    public void testBuildFromMessage() {
        Message<User> original =
                MessageBuilder.withPayload(new User("Kate", 30))
                .setHeader("processor", "userService")
                .build();

        //Создайте новое сообщение с теми же payload и header-ами c помощью MessageBuilder
        Message<User> newMessage =
                MessageBuilder.fromMessage(original)
                .build();

        assertNotNull(newMessage);
        assertEquals(original.getPayload(), newMessage.getPayload());
        assertEquals(original.getHeaders().get("processor"), newMessage.getHeaders().get("processor"));
    }
}
