package sksingq.example.rabbit_mq_producer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String id;
    private String productName;
    private int quantity;
    private double price;
    private String status;
    private LocalDateTime createdAt;
}