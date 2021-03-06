package be.technifutur.stock.metier.service.stock;

import be.technifutur.stock.metier.service.stock.StockService;
import be.technifutur.stock.models.dtos.StockDTO;
import be.technifutur.stock.models.forms.StockForm;

import java.util.List;

public class StockServiceMock implements StockService {
    @Override
    public StockDTO getOne(Long id) { return null; }

    @Override
    public List<StockDTO> getAll() { return null; }

    @Override
    public StockDTO insert(StockForm form) { return null; }

    @Override
    public StockDTO update(Long id, StockForm form) { return null; }

    @Override
    public StockDTO delete(Long id) { return null; }

    @Override
    public StockDTO updateDelivery(Long id, Long idDeliery) {
        return null;
    }
}
