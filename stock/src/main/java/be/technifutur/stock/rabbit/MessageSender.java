package be.technifutur.stock.rabbit;

import org.slf4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
//
//@Component
//public class MessageSender implements InitializingBean {
//
//    private final RabbitTemplate template;
//    private final Logger logger = LoggerFactory.getLogger(MessageSender.class);
//
//    public MessageSender(RabbitTemplate template) {
//        this.template = template;
//    }
//
//    public void send(Object message){
//        String exchange = "direct.messages";
//        String key = "product";
//        logger.info("RABBIT SEND - " + exchange + "->" + key + " : " + message );
//        template.convertAndSend(exchange, key, message);
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        send("salut");
//    }
//}