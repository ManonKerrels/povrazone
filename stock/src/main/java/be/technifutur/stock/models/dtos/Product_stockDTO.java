package be.technifutur.stock.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Product_stockDTO {

    private Long id;
    private UUID reference;
    private StockDTO stock;

    @Data
    @AllArgsConstructor
    private static  class StockDTO{
        private Long id;
        private Long currentStock;
    }
}
