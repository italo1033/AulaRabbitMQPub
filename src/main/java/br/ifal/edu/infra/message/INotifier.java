package br.ifal.edu.infra.message;

public interface INotifier {
    void sendMessage(String message, String queueName);
}
