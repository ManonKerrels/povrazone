package be.technifutur.stock.controllers;

import be.technifutur.stock.exceptions.ElementNotFoundException;
import be.technifutur.stock.metier.service.stock.StockService;
import be.technifutur.stock.models.dtos.StockDTO;
import be.technifutur.stock.models.forms.StockForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    private final StockService service;

    public StockController(StockService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<StockDTO> getAll(){ return service.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<StockDTO> getOne(@PathVariable Long id){
        try {
            StockDTO dto = service.getOne(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .header("from controller", "StockController")
                    .body(service.getOne(id));
        } catch (ElementNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<StockDTO> insert(@RequestBody StockForm form){
        return ResponseEntity.ok(service.insert(form));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StockDTO> update(@RequestBody StockForm form, @PathVariable Long id){
        return ResponseEntity.ok(service.update(id, form));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StockDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

}
