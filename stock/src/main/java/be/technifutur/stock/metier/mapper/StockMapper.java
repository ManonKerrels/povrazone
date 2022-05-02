package be.technifutur.stock.metier.mapper;

import be.technifutur.stock.models.dtos.StockDTO;
import be.technifutur.stock.models.entities.Product;
import be.technifutur.stock.models.entities.Stock;
import be.technifutur.stock.models.forms.StockForm;
import org.springframework.stereotype.Service;

@Service
public class StockMapper {

    public StockDTO entityToDTO(Stock entity) {
        if(entity == null){
            return null;
        }

        Product productEntity = entity.getProduct();
        StockDTO.ProductDTO product = productEntity == null ? null : new StockDTO.ProductDTO(productEntity.getId(), productEntity.getName(), productEntity.getReference());

        return StockDTO.builder()
                .id(entity.getId())
                .currentStock(entity.getCurrentStock())
                .reference(entity.getReference())
                .product(product)
                .deliveries(entity.getDeliveries() == null ? null : entity.getDeliveries().stream().map(StockDTO.DeliveryDTO::of).toList())
                .build();
    }

    public Stock formToEntity(StockForm form){
        if(form == null){
            return null;
        }

        return Stock.builder()
                .currentStock(form.getCurrentStock())
//                .reference(form.getReference())
//                .referenceProduct(form.getReferenceProduct())
                .build();

    }

}
