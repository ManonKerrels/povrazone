package be.technifutur.order.utils;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.UUID;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.technifutur.order.models.entities.*;
import be.technifutur.order.repositories.*;

@Component
public class DatabaseFiller implements InitializingBean {
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private ClientRepository clientRepo;
    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private OrderProductRepository orderProductRepo;
    @Override
    public void afterPropertiesSet() throws Exception {
        orderProductRepo.deleteAll();
        productRepo.deleteAll();
        orderRepo.deleteAll();
        clientRepo.deleteAll();

        Product product = Product.builder()
            .name("Carottes")
            .reference(UUID.randomUUID())
            .build();
        productRepo.save(product);

        product = Product.builder()
        .name("Pommes")
        .reference(UUID.randomUUID())
        .build();
        productRepo.save(product);

        Client client = Client.builder()
        .username("test")
        .reference("95.04.20-259.97")
        .build();
        clientRepo.save(client);

        Order order = Order.builder()
            .orderDate(LocalDateTime.of(2020, 04, 25, 20, 0))
            .priceTotal(25d)
            .referenceOrder(UUID.randomUUID())
            .client(client)
            .build();
        orderRepo.save(order);

        OrderProduct orderp = OrderProduct.builder()
            .id(new OrderProductKey())
            .order(order)
            .product(product)
            .quantity(5)
            .shippingDate(LocalDateTime.of(2022, 04, 29, 15, 0))
            .build();
        orderProductRepo.save(orderp);
    }
}
