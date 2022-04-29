package be.technifutur.client.models.entities;

import be.technifutur.client.models.entities.embeddable.CartID;
import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cart")
public class CartItem
{
    @EmbeddedId
    private CartID cartID;

    @ManyToOne
    @MapsId("idClient")
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @MapsId("idProduct")
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;
}