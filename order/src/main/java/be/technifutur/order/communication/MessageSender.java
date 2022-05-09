package be.technifutur.order.communication;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.technifutur.order.models.dtos.OrderDTO;
import be.technifutur.order.models.entities.Order;

@Component
public class MessageSender implements InitializingBean{
    private Logger log = LoggerFactory.getLogger(MessageSender.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ObjectMapper mapper;
    // @Autowired
    // private ReservationService service;

    public void sendOrderToClient(OrderDTO order) throws JsonProcessingException
    {
        // Message message = MessageBuilder.withBody(json.getBytes()).setContentType("application/json").build();
        
        // rabbitTemplate.send("topic.facture", "facture.compta",message);

       // rabbitTemplate.convertAndSend("topic.facture", "facture.compta",json);
       String reservJson = mapper.writeValueAsString(order);
       Message m = MessageBuilder.withBody(reservJson.getBytes())
                .setContentType("application/json")
                .build();
       rabbitTemplate.send("direct.povrazone", "order",m);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // Facture f = new Facture("Luc Dubois", 10, "l'adresse", List.of(new Facture.Produit("Carotte",25d)));

        // ObjectMapper mapper = new ObjectMapper();
        // String fJson = mapper.writeValueAsString(f);

        // sendFactureToCompta(fJson);


        // Reservation reservation = new Reservation(UUID.randomUUID(), LocalDate.of(2022, 05, 03), LocalDate.of(2022, 05, 01), Status.DEMANDE);

        // log.info("Reservation SEND - " + reservation);

        // service.create(reservation);

        // String reservJson = mapper.writeValueAsString(reservation);
        

        // sendReservationToFacture(reservJson);
    }
    
}
