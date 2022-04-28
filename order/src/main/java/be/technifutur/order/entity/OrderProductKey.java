package be.technifutur.order.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
@EqualsAndHashCode
public class OrderProductKey implements Serializable{
    private long idOrder;
    private long idProduct;
}
