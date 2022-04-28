package be.technifutur.product.business.services.impl;

import be.technifutur.product.business.mappers.ProductMapper;
import be.technifutur.product.business.services.ProductService;
import be.technifutur.product.exceptions.ElementNotFoundException;
import be.technifutur.product.models.dto.ProductDTO;
import be.technifutur.product.models.entities.Product;
import be.technifutur.product.models.forms.ProductForm;
import be.technifutur.product.repositories.ProductRepository;

import java.util.List;
import java.util.Locale;

public class ProductServiceImpl implements ProductService {

    private final ProductMapper mapper;
    private final ProductRepository repository;

    public ProductServiceImpl(ProductMapper mapper, ProductRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public ProductDTO insert(ProductForm form) {
        Product entity = mapper.formToEntity(form);
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public ProductDTO getOne(Long id) {
        return repository.findById(id)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, ProductDTO.class));
    }

    @Override
    public List<ProductDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    @Override
    public List<ProductDTO> getByName(String name) {
        return repository.findAll().stream()
                .filter(restaurant -> restaurant.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT)))
                .map(mapper::entityToDTO)
                .toList();
    }

    @Override
    public ProductDTO update(Long id, ProductForm form) {
        Product entity = repository.findById(id)
                .orElseThrow( () -> new ElementNotFoundException(id, ProductDTO.class));

        entity.setName(form.getName());
        entity.setBrand(form.getBrand());
        entity.setPrice(form.getPrice());
        entity.setCategories(form.getCategories());

        entity = repository.save(entity);

        return mapper.entityToDTO(entity);
    }

    @Override
    public ProductDTO delete(Long id) {
        ProductDTO dto = getOne(id);
        repository.deleteById(id);
        return dto;
    }
}
