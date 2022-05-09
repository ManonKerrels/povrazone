package be.technifutur.stock.rabbit;

import be.technifutur.stock.models.dtos.StockDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class RabbitSender implements InitializingBean {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper mapper;
    private final Logger logger = LoggerFactory.getLogger(RabbitSender.class);

    public RabbitSender(RabbitTemplate rabbitTemplate, ObjectMapper mapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.mapper = mapper;
    }

    public void sendStockToProduct(StockDTO dto) throws JsonProcessingException {
        String stockJson = mapper.writeValueAsString(dto);
        Message m = MessageBuilder.withBody(stockJson.getBytes())
                        .setContentType("application/json")
                        .build();
        rabbitTemplate.send("direct.povrazone", "stock", m);
    }

    @Override
    public void afterPropertiesSet() throws Exception { }
}
