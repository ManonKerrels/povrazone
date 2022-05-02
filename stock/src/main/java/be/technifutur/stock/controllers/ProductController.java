package be.technifutur.stock.controllers;

import be.technifutur.stock.exceptions.ElementNotFoundException;
import be.technifutur.stock.metier.service.product.ProductService;
import be.technifutur.stock.models.dtos.ProductDTO;
import be.technifutur.stock.models.entities.Product;
import be.technifutur.stock.models.forms.ProductForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) { this.service = service; }


    @GetMapping("")
    public List<ProductDTO> getAll(){ return service.getAll(); }

    @GetMapping("/{UUID}")
    public ResponseEntity<Optional<Product>> getOne(@PathVariable UUID reference){
        try {
            Optional<Product> dto = service.getOneByUUID(reference);
            return ResponseEntity.ok(service.getOneByUUID(reference));
        } catch (ElementNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductForm form){
        return ok(service.insert(form));
    }

    @PutMapping("/update/{UUID}")
    public ResponseEntity<ProductDTO> update(@RequestBody ProductForm form, @PathVariable UUID reference){
        return ok(service.updateByUUID(reference, form));
    }

    @DeleteMapping("/delete/{UUID}")
    public ResponseEntity<ProductDTO> delete(@PathVariable UUID reference){
        return ok(service.deleteByUUID(reference));
    }
}
