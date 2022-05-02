package be.technifutur.stock.metier.mapper;

import be.technifutur.stock.models.dtos.ProductDTO;
import be.technifutur.stock.models.entities.Product;
import be.technifutur.stock.models.entities.Stock;
import be.technifutur.stock.models.forms.ProductForm;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public ProductDTO entityToDTO(Product entity){
        if(entity == null){
            return null;
        }

        Stock stockEntity = entity.getStock();
        ProductDTO.StockDTO stock = stockEntity == null ? null : new ProductDTO.StockDTO(stockEntity.getId(), stockEntity.getCurrentStock(), stockEntity.getReference());

        return ProductDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .reference(entity.getReference())
                .stock(stock)
                .build();
    }

    public Product formToEntity(ProductForm form){
        if(form == null){
            return null;
        }

        return Product.builder()
                .name(form.getName())
                .reference(form.getReference())
                .build();
    }
}
