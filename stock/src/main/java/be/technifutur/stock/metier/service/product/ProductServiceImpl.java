package be.technifutur.stock.metier.service.product;

import be.technifutur.stock.exceptions.UUIDNotFoundException;
import be.technifutur.stock.metier.mapper.ProductMapper;
import be.technifutur.stock.models.dtos.ProductDTO;
import be.technifutur.stock.models.entities.Product;
import be.technifutur.stock.models.forms.ProductForm;
import be.technifutur.stock.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductServiceImpl(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public ProductDTO getOneByUUID(UUID reference) {
        ProductDTO dto = repository.findByReference(reference)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new UUIDNotFoundException(reference));
        return dto;
    }

    @Override
    public List<ProductDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    @Override
    public ProductDTO insert(ProductForm form) {
        Product entity = mapper.formToEntity(form);
        entity.setName(form.getName());
        entity.setReference(form.getReference());
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public ProductDTO updateByUUID(UUID reference, ProductForm form) {
        Product entity = (Product) repository.findByReference(reference)
                .orElseThrow(() -> new UUIDNotFoundException(reference));
        entity.setName(form.getName());
        entity.setReference(form.getReference());
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public ProductDTO deleteByUUID(UUID reference) {
        ProductDTO dto = getOneByUUID(reference);
        repository.deleteByReference(dto);
        return dto;
    }
}
