package be.technifutur.product.business.mappers;

import be.technifutur.product.models.dto.ProductDTO;
import be.technifutur.product.models.entities.Category;
import be.technifutur.product.models.entities.Product;
import be.technifutur.product.models.forms.ProductForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMapper {

    public ProductDTO entityToDTO(Product entity){

        if (entity == null)
            return null;

//
//        Category category = entity.getCategory();
//        ProductDTO.CategoryDTO categoryDTO =
//                category == null ? null :
//                        new ProductDTO.CategoryDTO(category.getId(), category.getName());



        return ProductDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .brand(entity.getBrand())
                .price(entity.getPrice())
                .reference(entity.getReference())
//                .category(categoryDTO)
                .build();
    }

    public Product formToEntity(ProductForm form){

        if(form == null){
            return null;
        }

        return Product.builder()
                .id(form.getId())
                .name(form.getName())
                .brand(form.getBrand())
                .price(form.getPrice())
                .reference(form.getReference())
//                .category(form.getCategory())
                .build();


    }

}
