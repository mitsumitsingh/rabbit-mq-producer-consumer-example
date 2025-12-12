package sksingq.example.rabbit_mq_producer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import sksingq.example.rabbit_mq_producer.configurations.RabbitMQConfig;
import sksingq.example.rabbit_mq_producer.pojo.Order;

@Component
public class MessageConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(@Payload String message) {
        System.out.println(" [x] Received: " + message);
        // Process the message
    }

    // Consuming custom objects
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveOrder(@Payload Order order) {
        System.out.println(" [x] Processing order: " + order.getId());
        // Process the order
    }
}