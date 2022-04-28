package be.technifutur.order.models.entities;

import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Builder
@Entity
@Table(name = "product")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "product_id")
    private long id;

    @Column(nullable = false, name = "product_name", length = 50)
    private String name;

    @Column(name = "product_dispo")
    private boolean dispo;

    @Column(nullable = false, name = "product_price")
    private double price;

    @Column(nullable = false, unique = true, name = "product_reference")
    private UUID reference;
    
    @OneToMany(mappedBy = "product")
    Set<OrderProduct> orderProducts;
}
