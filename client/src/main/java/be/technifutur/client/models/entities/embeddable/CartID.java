package be.technifutur.client.models.entities.embeddable;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class CartID implements Serializable
{
    private Long idProduct;
    private Long idClient;
}
