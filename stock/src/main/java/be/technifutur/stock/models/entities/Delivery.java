package be.technifutur.stock.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @ManyToMany
    @JoinColumn
    List<Stock> stocks = new ArrayList<>();

    @ManyToMany
    @JoinColumn
    List<Supplier> suppliers = new ArrayList<>();

}
