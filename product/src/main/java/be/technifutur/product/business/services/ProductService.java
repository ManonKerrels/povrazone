package be.technifutur.product.business.services;

import be.technifutur.product.models.dto.ProductDTO;
import be.technifutur.product.models.entities.Product;
import be.technifutur.product.models.entities.Stock;
import be.technifutur.product.models.forms.ProductForm;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    // CREATE
    public void insert(ProductForm form);

    // READ
    public ProductDTO getOne(Long id);
    public List<ProductDTO> getAll();
    public List<ProductDTO> getByName(String name);
    public ProductDTO getOneByUUID(UUID ref);


    // UPDATE
    public ProductDTO update(Long id, ProductForm form);
    public void setAvailability(Stock stock);


    // DELETE
    public ProductDTO delete(Long id);


}
