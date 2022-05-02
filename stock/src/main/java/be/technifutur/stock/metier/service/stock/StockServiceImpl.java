package be.technifutur.stock.metier.service.stock;

import be.technifutur.stock.exceptions.ElementNotFoundException;
import be.technifutur.stock.metier.mapper.StockMapper;
import be.technifutur.stock.models.dtos.StockDTO;
import be.technifutur.stock.models.entities.Stock;
import be.technifutur.stock.models.forms.StockForm;
import be.technifutur.stock.repositories.DeliveryRepository;
import be.technifutur.stock.repositories.ProductRepository;
import be.technifutur.stock.repositories.StockRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class StockServiceImpl implements StockService {

    private final StockRepository repository;
    private final StockMapper mapper;
    private final DeliveryRepository deliveryRepository;
    private final ProductRepository productRepository;

    public StockServiceImpl(StockRepository repository, StockMapper mapper, DeliveryRepository deliveryRepository, ProductRepository productRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.deliveryRepository = deliveryRepository;
        this.productRepository = productRepository;
    }


    @Override
    public StockDTO getOne(Long id) {
        StockDTO dto = repository.findById(id)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, Stock.class));
        return dto;
    }

    @Override
    public List<StockDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    @Override
    public StockDTO insert(StockForm form) {
        Stock entity = mapper.formToEntity(form);
        entity.setReference(UUID.randomUUID());
        entity.setProduct(productRepository.findById(form.getProductId()).orElseThrow());
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public StockDTO update(Long id, StockForm form) {
        Stock entity = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, Stock.class));
        entity.setCurrentStock(form.getCurrentStock());
        entity.setProduct(productRepository.findById(form.getProductId()).orElseThrow());
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public StockDTO delete(Long id) {
        StockDTO dto = getOne(id);
        repository.deleteById(id);
        return dto;
    }

    @Override
    public StockDTO updateDelivery(Long id, Long idDeliery) {
        return null;
    }


}
