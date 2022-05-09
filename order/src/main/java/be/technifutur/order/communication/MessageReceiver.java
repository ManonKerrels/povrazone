package be.technifutur.order.communication;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.technifutur.order.services.OrderService;

@Component
public class MessageReceiver {

    private Logger log = LoggerFactory.getLogger(MessageReceiver.class);
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private OrderService service;
    
    @RabbitListener(queues = "product_queue")
    public void receiveProduct(String message) throws JsonProcessingException{
        // ProductDTO f = mapper.readValue(message, ProductDTO.class);
        // log.info("FACTURE RECEIVED - " + f);

        // service.setToFacture(f.getReserv_ref());

        // log.info("RESERVATION FACTURE");

        // List<Reservation> reservFactures = service.getResvFactures();

        // log.info("Reservation facturés : " + reservFactures.toString());

    }
}
