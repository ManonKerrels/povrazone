package be.technifutur.product.models.forms;

import lombok.Data;

import java.util.UUID;

@Data
public class StockForm {

    private Long id;
    private Long currentStock;
    private UUID reference;
}
