package be.technifutur.product.communication;

import be.technifutur.product.business.services.ProductService;
import be.technifutur.product.models.entities.Stock;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    private final ProductService service;
    private final ObjectMapper mapper;

    public MessageReceiver(ProductService service, ObjectMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @RabbitListener(queues = "stock_queue")
    public void receiveStock(String message) throws JsonProcessingException {
        Stock stock = mapper.readValue(message, Stock.class);
        service.setAvailability(stock);
    }
}
