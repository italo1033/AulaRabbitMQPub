package br.ifal.edu.infra.message;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Notifier implements INotifier {

    @Override
    public void sendMessage(String message, String queueName) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");

        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            channel.queueDeclare(queueName, false, false, false, null);
            System.out.println("Enviando mensagem para [" + queueName + "]...");
            channel.basicPublish("", queueName, null, message.getBytes("UTF-8"));
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
