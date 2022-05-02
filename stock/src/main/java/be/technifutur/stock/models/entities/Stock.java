package be.technifutur.stock.models.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id", nullable = false)
    private Long id;

    @Column
    private int currentStock;

    @Column(nullable = false, unique = true)
    private UUID reference;

    @OneToOne(mappedBy = "stock", cascade = CascadeType.PERSIST)
    private Product product;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.PERSIST)
    private List<Delivery> deliveries = new ArrayList<>();
}
