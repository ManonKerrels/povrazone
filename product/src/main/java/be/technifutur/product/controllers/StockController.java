package be.technifutur.product.controllers;

import be.technifutur.product.business.services.StockService;
import be.technifutur.product.models.dto.StockDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    private final StockService service;

    public StockController(StockService service) {
        this.service = service;
    }

    // GET - http://localhost:8084/stock
    @GetMapping
    public List<StockDTO> getAll(){
        return service.getAll();
    }
    
}
