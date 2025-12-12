package sksingq.example.rabbit_mq_producer.configurations;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultJacksonJavaTypeMapper;
import org.springframework.amqp.support.converter.JacksonJavaTypeMapper;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "hello_queue";
    public static final String EXCHANGE_NAME = "hello_exchange";
    public static final String ROUTING_KEY = "hello_key";

    @Bean
    public Queue helloQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public DirectExchange helloExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue helloQueue, DirectExchange helloExchange) {
        return BindingBuilder
                .bind(helloQueue)
                .to(helloExchange)
                .with(ROUTING_KEY);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }

    @Bean
    public JacksonJsonMessageConverter messageConverter() {
        // Create a type mapper if you need trusted package handling
        JacksonJavaTypeMapper typeMapper = new DefaultJacksonJavaTypeMapper();
        // e.g., typeMapper.setTrustedPackages("com.your.package");

        JacksonJsonMessageConverter converter = new JacksonJsonMessageConverter();
        converter.setJavaTypeMapper(typeMapper);

        return converter;
    }
}