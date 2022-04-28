package be.technifutur.stock.models.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class StockForm {

    private Long currentStock;
    private UUID reference;
    private Product_stock product_stock;
    private List<Delivery> deliveries;

    @Data
    @AllArgsConstructor
    public static class Product_stock{
        private Long id;
        private UUID reference;
    }

    @Data
    @AllArgsConstructor
    public static class Delivery{
        private Long id;
        private Date dateDelivery;
    }
}
