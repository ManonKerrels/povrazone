package be.technifutur.client.services;

import be.technifutur.client.models.dtos.ProductDTO;
import be.technifutur.client.models.entities.Product;
import be.technifutur.client.models.forms.ProductForm;

import java.util.Optional;
import java.util.UUID;

public interface ProductService
{
    Optional<Product> getOneByUUID(UUID ref);
    ProductDTO insert(ProductForm form);
    ProductDTO updateByUUID(UUID ref, ProductForm form);
    ProductDTO deleteByUUID(UUID ref);
}
