package be.technifutur.product.communication;

import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.*;

@Configuration
public class RabbitConfig {

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean("product_queue")
    public Queue productQueue() {
        return new Queue("product_queue", true);
    }

    @Bean("stock_queue")
    public Queue stockQueue() {
        return new Queue("stock_queue", true);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct.povrazone");
    }

    @Bean
    public Binding binding(DirectExchange exchange, Queue product_queue) {
        return BindingBuilder.bind(product_queue).to(exchange).with("product");
    }
}
