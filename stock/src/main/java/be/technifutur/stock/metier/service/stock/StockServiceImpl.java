package be.technifutur.stock.metier.service.stock;

import be.technifutur.stock.metier.mapper.StockMapper;
import be.technifutur.stock.models.dtos.StockDTO;
import be.technifutur.stock.models.forms.StockForm;
import be.technifutur.stock.repositories.StockRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StockServiceImpl implements StockService{

    private final StockRepository repository;
    private final StockMapper mapper;

    public StockServiceImpl(StockRepository repository, StockMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public StockDTO getOne(Long id) {
        return null;
    }

    @Override
    public List<StockDTO> getAll() {
        return null;
    }

    @Override
    public StockDTO insert(StockForm form) {
        return null;
    }

    @Override
    public StockDTO update(StockForm form) {
        return null;
    }

    @Override
    public StockDTO delete(Long id) {
        return null;
    }
}
