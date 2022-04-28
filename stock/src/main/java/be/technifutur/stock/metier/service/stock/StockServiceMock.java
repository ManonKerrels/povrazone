package be.technifutur.stock.metier.service.stock;

import be.technifutur.stock.models.dtos.StockDTO;
import be.technifutur.stock.models.forms.StockForm;

import java.util.List;

public class StockServiceMock implements StockService{
    @Override
    public StockDTO getOne(Long id) { return null; }

    @Override
    public List<StockDTO> getAll() { return null; }

    @Override
    public StockDTO insert(StockForm form) { return null; }

    @Override
    public StockDTO update(StockForm form) { return null; }

    @Override
    public StockDTO delete(Long id) { return null; }
}
