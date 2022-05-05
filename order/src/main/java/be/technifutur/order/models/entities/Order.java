package be.technifutur.order.models.entities;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.*;

@Entity
@Builder
@Table(name = "orders")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @Column(name = "price_total")
    private double priceTotal;
    @Column(name="reference_order",updatable = false, nullable = false, unique = true)
    private UUID referenceOrder;
    @OneToMany(mappedBy = "order")
    Set<OrderProduct> orderProducts;
    @ManyToOne
    private Client client;
}
