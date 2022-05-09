package be.technifutur.product.communication;

import be.technifutur.product.models.entities.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageSender implements InitializingBean {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper mapper;

    public MessageSender(RabbitTemplate rabbitTemplate, ObjectMapper mapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.mapper = mapper;
    }

    public void sendProduct(Product product) throws JsonProcessingException {
        String bJson = mapper.writeValueAsString(product);
        rabbitTemplate.convertAndSend("direct.povrazone", "product", bJson);
    }

    public void sendProducts(List<Product> products) throws JsonProcessingException {
        String bJson = mapper.writeValueAsString(products);
        rabbitTemplate.convertAndSend("direct.povrazone", "product", bJson);
    }

    @Override
    public void afterPropertiesSet() throws Exception {}
}
