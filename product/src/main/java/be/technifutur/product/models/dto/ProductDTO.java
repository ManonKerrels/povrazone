package be.technifutur.product.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@Builder
public class ProductDTO {

    private Long id;
    private String name;
    private String brand;
    private double price;
    private UUID reference;
    private CategoryDTO category;
    private Boolean availability;

    @AllArgsConstructor
    @Data
    public static class CategoryDTO{
        private Long id;
        private String name;
    }


}
