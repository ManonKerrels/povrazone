package be.technifutur.order.entity;

import java.time.LocalDateTime;
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
    private long id_order;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime order_date;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime shipping_date;
    @Column(unique = true)
    private UUID reference_order;
}
