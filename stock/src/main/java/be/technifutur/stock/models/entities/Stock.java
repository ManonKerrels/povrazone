package be.technifutur.stock.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column
    private String reference;

    @OneToOne
    @JoinColumn
    private Product_stock product_stock;

    @ManyToMany
    @JoinColumn
    private List<Delivery> deliveries = new ArrayList<>();
}
