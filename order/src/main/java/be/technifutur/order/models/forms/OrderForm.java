package be.technifutur.order.models.forms;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import be.technifutur.order.models.entities.OrderProduct;

public class OrderForm {
    //private Long id;
    private LocalDateTime shippingDate;
    private UUID referenceOrder;
    private Set<OrderProduct> orderProducts;
}
