package be.technifutur.stock.models.dtos;

import be.technifutur.stock.models.entities.Delivery;
import be.technifutur.stock.models.entities.Stock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class StockDTO {

    private Long id;
    private int currentStock;
    private UUID reference;
    private Product_stockDTO product_stock;
    private List<DeliveryDTO> deliveries;

    @Data
    @AllArgsConstructor
    public static class Product_stockDTO{
        private Long id;
        private UUID reference;
    }

    @Data
    @AllArgsConstructor
    public static class DeliveryDTO {
        private Long id;
        private Date dateDelivery;

        public static DeliveryDTO of(Delivery entity){
            if (entity == null){
                return null;
            }
            return new DeliveryDTO(entity.getId(), entity.getDateDelivery());
        }
    }
}
