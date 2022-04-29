package be.technifutur.stock.metier.service.stock;

import be.technifutur.stock.models.dtos.StockDTO;
import be.technifutur.stock.models.forms.StockForm;

import java.util.List;

public interface StockService {

    StockDTO getOne(Long id);

    List<StockDTO> getAll();

    StockDTO insert(StockForm form);

    StockDTO update(Long id, StockForm form);

    StockDTO delete(Long id);

    StockDTO updateProduct_stock(Long id, Long idProduct);

    StockDTO updateDelivery(Long id, Long idDeliery);

}
