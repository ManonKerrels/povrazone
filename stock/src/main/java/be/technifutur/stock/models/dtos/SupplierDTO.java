package be.technifutur.stock.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class SupplierDTO {

    private Long id;
    private String name;
    private String address;
    private List<DeliveryDTO> deliveries;

    @Data
    @AllArgsConstructor
    private static class DeliveryDTO{
        private Long id;
        private Date dateDelivery;
    }
}
