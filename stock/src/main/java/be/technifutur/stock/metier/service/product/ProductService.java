package be.technifutur.stock.metier.service.product;

import be.technifutur.stock.models.dtos.ProductDTO;
import be.technifutur.stock.models.forms.ProductForm;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductDTO getOneByUUID (UUID reference);

    List<ProductDTO> getAll();

    ProductDTO insert (ProductForm form);

    ProductDTO updateByUUID (UUID reference, ProductForm form);

    ProductDTO deleteByUUID (UUID reference);
}
