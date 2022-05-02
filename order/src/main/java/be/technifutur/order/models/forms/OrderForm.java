package be.technifutur.order.models.forms;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import be.technifutur.order.models.entities.Client;
import be.technifutur.order.models.entities.OrderProduct;
import be.technifutur.order.models.entities.Product;
import lombok.*;

@Data
public class OrderForm {
    //private Long id;
    private LocalDateTime orderDate;
    private double priceTotal;
    //private UUID referenceOrder;
    //private Set<OrderProduct> orderProducts;
    private List<ProductForm> products;
    private Long clientId;
}
