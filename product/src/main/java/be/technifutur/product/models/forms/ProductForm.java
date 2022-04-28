package be.technifutur.product.models.forms;

import be.technifutur.product.models.entities.Category;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ProductForm {

    private long id;
    private String name;
    private String brand;
    private double price;
    private UUID reference;
    private List<Category> categories;
}
