package be.technifutur.stock.rabbit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public void sendStockToProduct(String json){
        rabbitTemplate.convertAndSend("direct.povrazone", "product", json);
    }

    @Override
    public void afterPropertiesSet() throws Exception { }
}
