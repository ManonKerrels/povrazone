package be.technifutur.stock.models.forms;

import be.technifutur.stock.models.entities.Stock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Product_stockForm {

    private UUID reference;
    private Stock stock;

    @Data
    @AllArgsConstructor
    public static class Stock{
        private Long id;
        private int currentStock;
        private UUID reference;
    }
}
