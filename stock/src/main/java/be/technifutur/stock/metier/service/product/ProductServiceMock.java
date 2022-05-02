package be.technifutur.stock.metier.service.product;

import be.technifutur.stock.models.dtos.ProductDTO;
import be.technifutur.stock.models.entities.Product;
import be.technifutur.stock.models.forms.ProductForm;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProductServiceMock implements ProductService{
    @Override
    public Optional<Product> getOneByUUID(UUID reference) {
        return null;
    }

    @Override
    public List<ProductDTO> getAll() {
        return null;
    }

    @Override
    public ProductDTO insert(ProductForm form) {
        return null;
    }

    @Override
    public ProductDTO updateByUUID(UUID reference, ProductForm form) {
        return null;
    }

    @Override
    public ProductDTO deleteByUUID(UUID reference) {
        return null;
    }
}
