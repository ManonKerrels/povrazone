package be.technifutur.product.models.forms;

import be.technifutur.product.models.entities.Product;
import lombok.Data;

import java.util.List;

@Data
public class CategoryForm {

    private Long id;
    private String name;
    private List<Product> products;
}
