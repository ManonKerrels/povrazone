package be.technifutur.stock.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_name", length = 50)
    private String name;

    @Column(nullable = false, name = "product_reference", unique = true)
    private UUID reference;
}
