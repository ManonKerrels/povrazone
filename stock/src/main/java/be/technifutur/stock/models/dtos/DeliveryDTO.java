package be.technifutur.stock.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class DeliveryDTO {

    private Long id;
    private Date dateDelivery;
    private StockDTO stock;
    private SupplierDTO supplier;

    @Data
    @AllArgsConstructor
    private static class StockDTO{
        private Long id;
        private Long currentStock;
    }

    @Data
    @AllArgsConstructor
    private static class SupplierDTO{
        private Long id;
        private String name;
    }
}
