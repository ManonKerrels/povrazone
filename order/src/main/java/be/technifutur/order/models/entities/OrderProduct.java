package be.technifutur.order.models.entities;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Entity
@Table(name = "order_product")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct {
    @EmbeddedId
    OrderProductKey id;

    @ManyToOne
    @MapsId("idOrder")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("idProduct")
    @JoinColumn(name = "product_id")
    private Product product;

    
    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime orderDate;

    @Column(name = "quantity")
    private int quantity;
}
