package be.technifutur.order.models.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
@EqualsAndHashCode
public class OrderProductKey implements Serializable{
    private Long idOrder;
    private Long idProduct;
}
