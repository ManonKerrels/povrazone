package be.technifutur.product.business.services;

import be.technifutur.product.models.dto.StockDTO;


import java.util.List;

public interface StockService {

    // READ
    public StockDTO getOne(Long id);
    public List<StockDTO> getAll();
}
