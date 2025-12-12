package sksingq.example.rabbit_mq_producer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sksingq.example.rabbit_mq_producer.configurations.RabbitMQConfig;
import sksingq.example.rabbit_mq_producer.pojo.Order;

@Service
public class MessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_KEY,
                message
        );
        System.out.println(" [x] Sent: " + message);
    }

    // Sending custom objects
    public void sendOrder(Order order) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_KEY,
                order
        );
        System.out.println(" [x] Sent order: " + order.getId());
    }
}
