package be.technifutur.order.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    // @Bean
    // public ObjectMapper objectMapper(){
    //     return new ObjectMapper().registerModule(new JavaTimeModule());
    // }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean("order_queue")
    public Queue orderQueue(){
        return new Queue("order_queue");
    }

    @Bean("client_queue")
    public Queue clientQueue(){
        return new Queue("client_queue", true);
    }

    @Bean("product_queue")
    public Queue productQueue(){
        return new Queue("product_queue", true);
    }

    // @Bean
    // public FanoutExchange fanoutExchange(){
    //     return new FanoutExchange("fanout.facture");
    // }

    // @Bean
    // public TopicExchange topicExchange(){
    //     return new TopicExchange("topic.facture");
    // }

    
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct.povrazone");
    }

    // @Bean
    // public Binding fBind(DirectExchange exchange, @Qualifier("facture_queue") Queue queue){
    //     return BindingBuilder.bind(queue).to(exchange).with("facture");
    // }

    @Bean
    public Binding cBind(DirectExchange exchange, Queue clientQueue){
        return BindingBuilder.bind(clientQueue).to(exchange).with("client");
    }

    @Bean
    public Binding pBind(DirectExchange exchange, Queue productQueue){
        return BindingBuilder.bind(productQueue).to(exchange).with("product");
    }
}
