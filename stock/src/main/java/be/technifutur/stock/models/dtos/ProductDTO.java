package be.technifutur.stock.models.dtos;

import be.technifutur.stock.models.entities.Product;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private UUID reference;

    public static ProductDTO of(Product p)
    {
        if(p == null) return null;

        return new ProductDTO(
                p.getId(),
                p.getName(),
                p.getReference()
        );
    }
}
