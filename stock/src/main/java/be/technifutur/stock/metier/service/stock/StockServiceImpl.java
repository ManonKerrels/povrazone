package be.technifutur.stock.metier.service.stock;

import be.technifutur.stock.exceptions.ElementNotFoundException;
import be.technifutur.stock.metier.mapper.StockMapper;
import be.technifutur.stock.models.dtos.StockDTO;
import be.technifutur.stock.models.entities.Delivery;
import be.technifutur.stock.models.entities.Product_stock;
import be.technifutur.stock.models.entities.Stock;
import be.technifutur.stock.models.forms.StockForm;
import be.technifutur.stock.repositories.DeliveryRepository;
import be.technifutur.stock.repositories.Product_stockRepository;
import be.technifutur.stock.repositories.StockRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StockServiceImpl implements StockService{

    private final StockRepository repository;
    private final StockMapper mapper;
    private final Product_stockRepository product_stockRepository;
    private final DeliveryRepository deliveryRepository;

    public StockServiceImpl(StockRepository repository, StockMapper mapper, Product_stockRepository product_stockRepository, DeliveryRepository deliveryRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.product_stockRepository = product_stockRepository;
        this.deliveryRepository = deliveryRepository;
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
        Product_stock product_stock = product_stockRepository.findById(form.getProduct_stock().getId())
                .orElseThrow(()-> new ElementNotFoundException(form.getProduct_stock().getId(), Product_stock.class));
        entity.setProduct_stock(product_stock);

//        Delivery delivery = deliveryRepository.findById(form.getDeliveries().stream().map(StockDTO.DeliveryDTO::of).toList())
//                .orElseThrow(()-> new ElementNotFoundException(form.getDeliveries(), Delivery.class));
//        entity.setDeliveries(delivery);

        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public StockDTO update(Long id, StockForm form) {
        Stock entity = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, Stock.class));
        entity.setCurrentStock(form.getCurrentStock());
        entity.setReference(form.getReference());
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
    public StockDTO updateProduct_stock(Long id, Long idProduct) {
        Stock stock = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, Stock.class));
        Product_stock product_stock = product_stockRepository.findById(idProduct)
                .orElseThrow(() -> new ElementNotFoundException(idProduct, StockForm.Product_stock.class));
        stock.setProduct_stock(product_stock);
        return mapper.entityToDTO(stock);
    }

    @Override
    public StockDTO updateDelivery(Long id, Long idDeliery) {
        return null;
    }


}
