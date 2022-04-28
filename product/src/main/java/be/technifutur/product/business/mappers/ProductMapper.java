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


        List<Category> categories = entity.getCategories();
        List<ProductDTO.CategoryDTO> categoriesDTOS =
                categories == null ? null :
                        categories.stream().map(category -> new ProductDTO.CategoryDTO(category.getId(), category.getName())).toList();


        return ProductDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .brand(entity.getBrand())
                .price(entity.getPrice())
                .reference(entity.getReference())
                .categories(categoriesDTOS)
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
                .categories(form.getCategories())
                .build();


    }

}
