package be.technifutur.product.business.mappers;

import be.technifutur.product.models.dto.CategoryDTO;
import be.technifutur.product.models.entities.Category;
import be.technifutur.product.models.entities.Product;
import be.technifutur.product.models.forms.CategoryForm;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryMapper {

    public CategoryDTO entityToDTO(Category entity){

        if (entity == null)
            return null;


        List <Product> products = entity.getProducts();
        List <CategoryDTO.ProductDTO> productsDTO =
                products == null ? null :
                        products.stream().map(product -> new CategoryDTO.ProductDTO(product.getId(), product.getName())).toList();



        return CategoryDTO.builder()
                .name(entity.getName())
                .id(entity.getId())
                .products(productsDTO)
                .build();
    }

    public Category formToEntity(CategoryForm form){

        if(form == null){
            return null;
        }

        return Category.builder()
                .id(form.getId())
                .name(form.getName())
                .products(form.getProducts())
                .build();


    }

}
