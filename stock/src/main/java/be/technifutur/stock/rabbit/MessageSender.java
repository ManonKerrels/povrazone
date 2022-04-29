package be.technifutur.stock.rabbit;

import org.springframework.beans.factory.InitializingBean;

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
//        String key = "marie";
//        logger.info("RABBIT SEND - " + exchange + "->" + key + " : " + message );
//        template.convertAndSend(exchange, key, message);
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        send("salut");
//    }
//}