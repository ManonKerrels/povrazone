package be.technifutur.product.business.mappers;

import be.technifutur.product.models.dto.StockDTO;
import be.technifutur.product.models.entities.Product;
import be.technifutur.product.models.entities.Stock;
import be.technifutur.product.models.forms.ProductForm;
import be.technifutur.product.models.forms.StockForm;
import org.springframework.stereotype.Service;

@Service
public class StockMapper {

    public StockDTO entityToDTO(Stock entity){

        if (entity == null)
            return null;

        return StockDTO.builder()
                .id(entity.getId())
                .reference(entity.getReference())
                .currentStock(entity.getCurrentStock())
                .build();

    }

    public Stock formToEntity(StockForm form) {

        if (form == null) {
            return null;
        }

        return Stock.builder()
                .id(form.getId())
                .reference(form.getReference())
                .currentStock(form.getCurrentStock())
                .build();
    }
}
