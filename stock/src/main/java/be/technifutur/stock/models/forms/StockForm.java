package be.technifutur.stock.models.forms;

import be.technifutur.stock.models.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class StockForm {

    private int currentStock;
    private UUID reference;
    private Long productId;
    private List<Delivery> deliveries;


    @Data
    @AllArgsConstructor
    public static class Delivery{
        private Long id;
        private LocalDate dateDelivery;
    }
}
