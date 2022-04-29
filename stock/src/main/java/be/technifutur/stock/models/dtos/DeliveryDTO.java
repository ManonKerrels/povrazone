package be.technifutur.stock.models.dtos;

import be.technifutur.stock.models.entities.Stock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class DeliveryDTO {

    private Long id;
    private Date dateDelivery;
    private StockDTO stock;
    private SupplierDTO supplier;

    @Data
    @AllArgsConstructor
    public static class StockDTO{
        private Long id;
        private Long currentStock;
        private UUID reference;
    }

    @Data
    @AllArgsConstructor
    public static class SupplierDTO{
        private Long id;
        private String name;
    }
}
