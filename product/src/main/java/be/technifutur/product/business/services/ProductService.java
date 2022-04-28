package be.technifutur.product.business.services;

import be.technifutur.product.models.dto.ProductDTO;
import be.technifutur.product.models.forms.ProductForm;

import java.util.List;

public interface ProductService {

    // CREATE
    public ProductDTO insert(ProductForm form);

    // READ
    public ProductDTO getOne(Long id);
    public List<ProductDTO> getAll();
    public List<ProductDTO> getByName(String name);


    // UPDATE
    public ProductDTO update(Long id, ProductForm form);


    // DELETE
    public ProductDTO delete(Long id);
}
