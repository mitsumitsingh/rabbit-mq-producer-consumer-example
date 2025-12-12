package sksingq.example.rabbit_mq_producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sksingq.example.rabbit_mq_producer.pojo.Order;
import sksingq.example.rabbit_mq_producer.service.MessageProducer;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageProducer messageProducer;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        messageProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ");
    }

    @PostMapping("/order")
    public ResponseEntity<String> sendOrder(@RequestBody Order order) {
        messageProducer.sendOrder(order);
        return ResponseEntity.ok("Order sent to RabbitMQ");
    }
}