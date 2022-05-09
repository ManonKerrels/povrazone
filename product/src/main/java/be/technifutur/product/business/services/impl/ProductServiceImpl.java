package be.technifutur.product.business.services.impl;

import be.technifutur.product.business.mappers.ProductMapper;
import be.technifutur.product.business.services.ProductService;
import be.technifutur.product.communication.MessageSender;
import be.technifutur.product.exceptions.ElementNotFoundException;
import be.technifutur.product.models.dto.ProductDTO;
import be.technifutur.product.models.entities.Product;
import be.technifutur.product.models.entities.Stock;
import be.technifutur.product.models.forms.ProductForm;
import be.technifutur.product.repositories.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper mapper;
    private final ProductRepository repository;
    private final MessageSender sender;
    private final RestTemplate template;

    public ProductServiceImpl(ProductMapper mapper, ProductRepository repository, MessageSender sender, RestTemplate template) {
        this.mapper = mapper;
        this.repository = repository;
        this.sender = sender;
        this.template = template;
    }


    @Override
    public void insert(ProductForm form) {
        try {
            Product entity = mapper.formToEntity(form);
            sender.sendProduct(entity);
            repository.save(entity);
        } catch(Exception e) {
            e.printStackTrace();
        }
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
    public ProductDTO getOneByUUID(UUID ref) {
        Product product =  repository.findAll().stream()
                .filter(p -> p.getReference().equals(ref))
                .findFirst().orElseThrow();
        try{
            sender.sendProduct(product);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return mapper.entityToDTO(product);
        }

    @Override
    public ProductDTO update(Long id, ProductForm form) {
        Product entity = repository.findById(id)
                .orElseThrow( () -> new ElementNotFoundException(id, ProductDTO.class));

        entity.setName(form.getName());
        entity.setBrand(form.getBrand());
        entity.setPrice(form.getPrice());
        entity.setCategory(form.getCategory());

        entity = repository.save(entity);
        
        try{
            sender.sendProduct(entity);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return mapper.entityToDTO(entity);
    }

    @Override
    public void setAvailability(Stock stock) {

        Product entity = repository.findAll().stream()
                .filter(p -> p.getReference().equals(stock.getReference()))
                .findFirst().orElseThrow();

        entity.setAvailability(stock.getCurrentStock() > 0);
    }

    @Override
    public ProductDTO delete(Long id) {
        ProductDTO dto = getOne(id);
        repository.deleteById(id);
        return dto;
    }
}
