package be.technifutur.order.models.forms;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProductForm {
    private Long id;
    private LocalDateTime shippingDate;
    private int quantity;
}
