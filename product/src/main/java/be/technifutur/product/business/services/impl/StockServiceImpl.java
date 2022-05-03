package be.technifutur.product.business.services.impl;

import be.technifutur.product.business.mappers.StockMapper;
import be.technifutur.product.business.services.StockService;
import be.technifutur.product.exceptions.ElementNotFoundException;
import be.technifutur.product.models.dto.ProductDTO;
import be.technifutur.product.models.dto.StockDTO;
import be.technifutur.product.repositories.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StockServiceImpl implements StockService {

    private final StockMapper mapper;
    private final StockRepository repository;

    public StockServiceImpl(StockMapper mapper, StockRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public StockDTO getOneByUUID (UUID reference) {
        return repository.findByReference(reference)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(reference, ProductDTO.class));
    }

    @Override
    public List<StockDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::entityToDTO)
                .toList();
    }
}
