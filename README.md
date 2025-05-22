# RabbitMQ com Docker Compose

Este projeto configura um ambiente RabbitMQ usando Docker Compose.

## Como executar

Para iniciar o RabbitMQ, execute o seguinte comando na raiz do projeto:

```bash
docker-compose up -d
```

## Acesso à Interface de Gerenciamento

A interface de gerenciamento do RabbitMQ está disponível em:

- URL: http://localhost:15672
- Usuário: guest
- Senha: guest

## Portas utilizadas

- 5672: Porta padrão do RabbitMQ para conexões AMQP
- 15672: Porta da interface de gerenciamento web
