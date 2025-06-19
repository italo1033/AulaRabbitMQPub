package br.ifal.edu.service;

import br.ifal.edu.infra.message.IBillingService;
import com.rabbitmq.client.*;

public class BillingService implements IBillingService {

    private static final String QUEUE_NAME = "billing-queue";

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
            System.out.println("[BillingService] Aguardando mensagens...");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println("[BillingService] Processando fatura: " + message);
                // Aqui pode chamar lógica para registrar transações
            };

            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
