package be.technifutur.stock.metier.service.product;

import be.technifutur.stock.models.dtos.ProductDTO;
import be.technifutur.stock.models.entities.Product;
import be.technifutur.stock.models.forms.ProductForm;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

    Optional<Product> getOneByUUID (UUID reference);

    List<ProductDTO> getAll();

    ProductDTO insert (ProductForm form);

    ProductDTO updateByUUID (UUID reference, ProductForm form);

    ProductDTO deleteByUUID (UUID reference);
}
