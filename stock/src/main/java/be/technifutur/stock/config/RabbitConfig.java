package be.technifutur.stock.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public Queue stockQueue(){
        return new Queue("stock_queue", false);
    }

    @Bean
    public Queue productQueue(){
        return new Queue("product_queue", false);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct.povrazone", false, false);
    }

    @Bean
    public Binding binding(DirectExchange exchange, Queue productQueue){ //réutilisation du nom du Bean
        return BindingBuilder.bind(productQueue).to(exchange).with("product");
    }
}
