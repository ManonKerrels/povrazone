package be.technifutur.stock.models.forms;

import be.technifutur.stock.models.entities.Product;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProductForm {
    private String name;
    private UUID reference;

    public Product toProduct()
    {
        return Product.builder()
                .name(getName())
                .reference(getReference())
                .build();
    }
}
