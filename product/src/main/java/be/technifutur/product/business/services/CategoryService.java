package be.technifutur.product.business.services;

import be.technifutur.product.models.dto.CategoryDTO;
import be.technifutur.product.models.forms.CategoryForm;

import java.util.List;

public interface CategoryService {

    // CREATE
    public CategoryDTO insert(CategoryForm form);

    // READ
    public CategoryDTO getOne(Long id);
    public List<CategoryDTO> getAll();

    // UPDATE
    public CategoryDTO update(Long id, CategoryForm form);


    // DELETE
    public CategoryDTO delete(Long id);
}
