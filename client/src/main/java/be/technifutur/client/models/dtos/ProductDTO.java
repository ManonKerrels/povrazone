package be.technifutur.client.models.dtos;

import be.technifutur.client.models.entities.Product;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class ProductDTO implements Serializable
{
    private final Long id;
    private final String name;
    private final UUID reference;

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
