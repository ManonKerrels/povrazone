package be.technifutur.stock.models.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class DeliveryForm {

    private Date dateDelivery;
    private Stock stock;
    private Supplier supplier;

    @Data
    @AllArgsConstructor
    public static class Stock{
        private Long id;
        private int currentStock;
        private UUID reference;
    }

    @Data
    @AllArgsConstructor
    public static class Supplier{
        private Long id;
        private String name;
    }
}
