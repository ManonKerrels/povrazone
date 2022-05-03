package be.technifutur.product.business.services;

import be.technifutur.product.models.dto.StockDTO;


import java.util.List;
import java.util.UUID;

public interface StockService {

    // READ
    public StockDTO getOneByUUID (UUID reference);
    public List<StockDTO> getAll();
}
