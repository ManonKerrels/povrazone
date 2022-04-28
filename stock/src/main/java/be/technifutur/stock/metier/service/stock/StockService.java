package be.technifutur.stock.metier.service.stock;

import be.technifutur.stock.models.dtos.StockDTO;
import be.technifutur.stock.models.forms.StockForm;

import java.util.List;

public interface StockService {

    StockDTO getOne(Long id);

    List<StockDTO> getAll();

    StockDTO insert(StockForm form);

    StockDTO update(StockForm form);

    StockDTO delete(Long id);

    //update Product_stock
    //update List<Delivery>
}
