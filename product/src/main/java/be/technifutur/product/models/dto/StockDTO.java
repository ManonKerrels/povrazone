package be.technifutur.product.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;


@Data
@Builder
public class StockDTO {
    private Long id;
    private Long currentStock;
    private UUID reference;
}
