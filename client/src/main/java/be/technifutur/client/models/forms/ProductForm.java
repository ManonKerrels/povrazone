package be.technifutur.client.models.forms;

import be.technifutur.client.models.entities.Product;
import lombok.Data;

import java.util.UUID;

@Data
public class ProductForm
{
    private final String name;
    private final UUID reference;

    public Product toProduct()
    {
        return Product.builder()
                .name(getName())
                .reference(getReference())
                .build();
    }
}
