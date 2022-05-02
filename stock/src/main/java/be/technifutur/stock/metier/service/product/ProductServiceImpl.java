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
import java.util.Optional;
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
    public Optional<Product> getOneByUUID(UUID reference) {
        return repository.findAll().stream().filter((p) -> p.getReference() == reference).findFirst();
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
        return ProductDTO.of(repository.save(form.toProduct()));
    }

    @Override
    public ProductDTO updateByUUID(UUID reference, ProductForm form) {
        Product entity = getOneByUUID(reference).orElseThrow(() -> new UUIDNotFoundException(reference));
        entity.setName(form.getName());
        entity.setReference(form.getReference());
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public ProductDTO deleteByUUID(UUID reference) {
        Product entity = getOneByUUID(reference).orElseThrow(() -> new UUIDNotFoundException(reference));
        repository.deleteById(entity.getId());
        return ProductDTO.of(entity);
    }
}
