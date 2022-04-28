package be.technifutur.product.models.entities;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private long id;

    @Column(nullable = false, name = "product_name", length = 50)
    private String name;

    @ManyToOne
    private Product product;

}
