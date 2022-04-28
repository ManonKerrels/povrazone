package be.technifutur.stock.models.entities;

import lombok.*;

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
    private Long currentStock;

    @Column(nullable = false, unique = true)
    private UUID reference;

    @OneToOne
    @JoinColumn
    private Product_stock product_stock;

    @OneToMany(mappedBy = "stock")
    @JoinColumn
    private List<Delivery> deliveries = new ArrayList<>();
}
