package be.technifutur.stock.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private Date dateDelivery;

    @ManyToOne
    @JoinColumn
    private Stock stock;

    @ManyToOne
    @JoinColumn
    private Supplier supplier;

}
