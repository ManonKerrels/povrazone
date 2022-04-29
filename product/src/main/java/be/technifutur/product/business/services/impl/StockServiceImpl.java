package be.technifutur.product.business.services.impl;

import be.technifutur.product.business.mappers.StockMapper;
import be.technifutur.product.business.services.StockService;
import be.technifutur.product.exceptions.ElementNotFoundException;
import be.technifutur.product.models.dto.ProductDTO;
import be.technifutur.product.models.dto.StockDTO;
import be.technifutur.product.repositories.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final StockMapper mapper;
    private final StockRepository repository;

    public StockServiceImpl(StockMapper mapper, StockRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public StockDTO getOne(Long id) {
        return repository.findById(id)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, ProductDTO.class));
    }

    @Override
    public List<StockDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::entityToDTO)
                .toList();
    }
}
