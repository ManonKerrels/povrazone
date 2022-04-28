package be.technifutur.product.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private long id;

    @Column(nullable = false, name = "product_name", length = 50)
    private String name;

    @Column(nullable = false, name = "product_brand", length = 50)
    private String brand;

    @Column(nullable = false, name = "product_price")
    private double price;

    @Column(nullable = false, name = "product_reference")
    private UUID reference;

    @OneToMany(mappedBy = "product")
    private List<Category> categories = new ArrayList<>();


}
