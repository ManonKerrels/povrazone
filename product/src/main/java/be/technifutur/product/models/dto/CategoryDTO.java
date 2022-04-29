package be.technifutur.product.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDTO {

    private Long id;
    private String name;
    private List<ProductDTO> products;


    @AllArgsConstructor
    @Data
    public static class ProductDTO{
        private Long id;
        private String name;
    }
}
