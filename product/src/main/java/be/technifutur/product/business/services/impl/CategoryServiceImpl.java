package be.technifutur.product.business.services.impl;

import be.technifutur.product.business.mappers.CategoryMapper;
import be.technifutur.product.business.services.CategoryService;
import be.technifutur.product.exceptions.ElementNotFoundException;
import be.technifutur.product.models.dto.CategoryDTO;
import be.technifutur.product.models.dto.ProductDTO;
import be.technifutur.product.models.entities.Category;
import be.technifutur.product.models.forms.CategoryForm;
import be.technifutur.product.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper mapper;
    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryMapper mapper, CategoryRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public CategoryDTO insert(CategoryForm form) {
        Category entity = mapper.formToEntity(form);
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public CategoryDTO getOne(Long id) {
        return repository.findById(id)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, ProductDTO.class));
    }

    @Override
    public List<CategoryDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    @Override
    public CategoryDTO update(Long id, CategoryForm form) {
        Category entity = repository.findById(id)
                .orElseThrow( () -> new ElementNotFoundException(id, ProductDTO.class));

        entity.setName(form.getName());
        entity.setProducts(form.getProducts());

        entity = repository.save(entity);

        return mapper.entityToDTO(entity);
    }

    @Override
    public CategoryDTO delete(Long id) {
        CategoryDTO dto = getOne(id);
        repository.deleteById(id);
        return dto;
    }
}
