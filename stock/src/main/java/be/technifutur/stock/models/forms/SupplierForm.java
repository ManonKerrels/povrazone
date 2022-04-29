package be.technifutur.stock.models.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class SupplierForm {

    private String name;
    private String address;
    private List<Delivery> deliveries;

    @Data
    @AllArgsConstructor
    public static class Delivery{
        private Long id;
        private LocalDate dateDelivery;
    }
}
