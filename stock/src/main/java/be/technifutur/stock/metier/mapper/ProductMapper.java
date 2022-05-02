package be.technifutur.stock.metier.mapper;

import be.technifutur.stock.models.dtos.ProductDTO;
import be.technifutur.stock.models.entities.Product;
import be.technifutur.stock.models.forms.ProductForm;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public ProductDTO entityToDTO(Product entity){
        if(entity == null){
            return null;
        }

        return ProductDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .reference(entity.getReference())
                .build();
    }

    public ProductForm formToEntity(ProductForm form){
        if(form == null){
            return null;
        }

        return ProductForm.builder()
                .name(form.getName())
                .reference(form.getReference())
                .build();
    }
}
