package be.technifutur.stock.models.dtos;

import be.technifutur.stock.models.entities.Product;
import be.technifutur.stock.models.entities.Stock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private UUID reference;
    private StockDTO stock;

    public static ProductDTO of(Product product)
    {
        if(product == null) return null;

        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getReference(),
                StockDTO.of(product.getStock())
        );
    }

    @Data
    @AllArgsConstructor
    public static class StockDTO {
        private Long id;
        private int currentStock;
        private UUID reference;

        public static StockDTO of(Stock stock){
            if(stock == null) return null;

            return new StockDTO(
                    stock.getId(),
                    stock.getCurrentStock(),
                    stock.getReference()
            );
        }
    }


}
