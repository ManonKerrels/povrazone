package be.technifutur.stock.rabbit;

import be.technifutur.stock.models.entities.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceiver {

    private final Logger logger = LoggerFactory.getLogger(RabbitReceiver.class);
    private final ObjectMapper mapper;

    public RabbitReceiver(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @RabbitListener(queues = "product_queue")
    public void receiveProduct(String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Product p = mapper.readValue(message, Product.class);
        logger.info("PRODUCT RECEIVED - " + p);
    }

}
