package be.technifutur.client.models.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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

    @Getter
    @Setter
    @EqualsAndHashCode
    @Embeddable
    private class CartID implements Serializable
    {
        private Long idProduct;
        private Long idClient;
    }
}