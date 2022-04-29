package be.technifutur.client.models.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class ProductDto implements Serializable
{
    private final Long id;
    private final String name;
    private final UUID reference;
}
