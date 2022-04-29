package be.technifutur.stock.models.dtos;

import be.technifutur.stock.models.entities.Delivery;
import be.technifutur.stock.models.entities.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class StockDTO {

    private Long id;
    private int currentStock;
    private UUID reference;
    private UUID referenceProduct;
    private String nameProduct;
    private List<DeliveryDTO> deliveries;

//    @Data
//    @AllArgsConstructor
//    public static class Product_stockDTO{
//        private Long id;
//        private UUID reference;
//
//        public static Product_stockDTO of(Product_stock entity){
//            if (entity == null){
//                return null;
//            }
//            return new Product_stockDTO(entity.getId(), entity.getReference());
//        }
//    }

    @Data
    @AllArgsConstructor
    public static class DeliveryDTO {
        private Long id;
        private LocalDate dateDelivery;
        private SupplierDTO supplierdto;

        public static DeliveryDTO of(Delivery entity){
            if (entity == null){
                return null;
            }
            return new DeliveryDTO(entity.getId(), entity.getDateDelivery(), SupplierDTO.of(entity.getSupplier()));
        }
    }

    @Data
    @AllArgsConstructor
    public static class SupplierDTO{
        private Long id;
        private String name;
        private String address;

        public static SupplierDTO of(Supplier entity){
            if (entity == null){
                return null;
            }
            return new SupplierDTO(entity.getId(), entity.getName(), entity.getAddress());
        }
    }
}
