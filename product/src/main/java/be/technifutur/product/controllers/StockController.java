package be.technifutur.product.controllers;

import be.technifutur.product.business.services.StockService;
import be.technifutur.product.models.dto.ProductDTO;
import be.technifutur.product.models.dto.StockDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class StockController {

    private final StockService service;

    public StockController(StockService service) {
        this.service = service;
    }

    // GET - http://localhost:8080/stock
    @GetMapping
    public List<StockDTO> getAll(){
        return service.getAll();
    }


    // GET - http://localhost:8080/stock/id
    @GetMapping("/{id}")
    public ResponseEntity<StockDTO> getOne (@PathVariable Long id){
        return ResponseEntity.ok(service.getOne(id));
    }
}
