package be.technifutur.product.models.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(nullable = false, name = "product_name", length = 50)
    private String name;

    @Column(nullable = false, name = "product_brand", length = 50)
    private String brand;

    @Column(nullable = false, name = "product_price")
    private double price;

//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator"
//    )
    @Column(nullable = false, name = "product_reference", unique = true)
    private UUID reference;

    @ManyToOne
    private Category category ;


}
