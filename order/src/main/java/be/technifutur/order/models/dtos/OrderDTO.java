package be.technifutur.order.models.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import be.technifutur.order.models.entities.Order;
import be.technifutur.order.models.entities.OrderProduct;
import be.technifutur.order.models.entities.Product;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderDTO implements Serializable {
    private final Long id;
    private final LocalDateTime orderDate;
    private final LocalDateTime shippingDate;
    private final UUID referenceOrder;
    private final Set<OrderProductDTO> orderProducts;

    public static OrderDTO of(Order order){
        if( order == null )
            return null;

        return new OrderDTO(
            order.getId(),
            order.getOrderDate(),
            order.getShippingDate(),
            order.getReferenceOrder(),
            order.getOrderProducts() == null ? null : order.getOrderProducts().stream()
                        .map(OrderProductDTO::of)
                        .collect(Collectors.toSet())
        );
    }

    @Data
    public static class OrderProductDTO{
        private final OrderDTO order;
        private final ProductDTO product;
        private final int quantity;

        public static OrderProductDTO of(OrderProduct orderProduct){
            if( orderProduct == null )
                return null;
    
            return new OrderProductDTO(
                OrderDTO.of(orderProduct.getOrder()),
                ProductDTO.of(orderProduct.getProduct()),
                orderProduct.getQuantity()
            );
        }
    }

    @Data
    public static class ProductDTO{
        private final String name;
        private final boolean dispo;
        private final double price;
        private final UUID reference;
        public static ProductDTO of(Product product){
            if( product == null )
                return null;
    
            return new ProductDTO(
                product.getName(),
                product.isDispo(),
                product.getPrice(),
                product.getReference()
            );
        }
    }
}
