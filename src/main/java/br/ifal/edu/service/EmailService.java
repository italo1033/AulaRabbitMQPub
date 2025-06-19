package br.ifal.edu.service;


import br.ifal.edu.infra.message.IEmailService;
import com.rabbitmq.client.*;

public class EmailService implements IEmailService {

    private static final String QUEUE_NAME = "email-queue";

    @Override
    public void startListening() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");

        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println("[EmailService] Aguardando mensagens...");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println("[EmailService] Email enviado com conteúdo: " + message);
                // Aqui pode chamar um método real de envio de e-mail
            };

            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

