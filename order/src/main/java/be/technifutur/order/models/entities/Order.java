package be.technifutur.order.models.entities;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "order")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime orderDate;
    @Column(name = "shipping_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime shippingDate;
    @Column(name="reference_order",unique = true)
    private UUID referenceOrder;
    @OneToMany(mappedBy = "order")
    Set<OrderProduct> orderProducts;
}
