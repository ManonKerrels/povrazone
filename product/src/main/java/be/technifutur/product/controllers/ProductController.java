package be.technifutur.product.controllers;

import be.technifutur.product.business.services.ProductService;
import be.technifutur.product.models.dto.ProductDTO;
import be.technifutur.product.models.forms.ProductForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // GET - http://localhost:8080/product
    @GetMapping
    public List<ProductDTO> getAll(){
        return service.getAll();
    }


    // GET - http://localhost:8080/product/id
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getOne (@PathVariable Long id){
        return ResponseEntity.ok(service.getOne(id));
    }


    // GET - http://localhost:8080/product/searchByName/name
    @GetMapping("/searchByName/{name}")
    public List<ProductDTO> getByName (@PathVariable String name){
        return service.getByName(name);
    }


    // DELETE -  http://localhost:8080/product/id
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }


    // POST -http://localhost:8080/product/add
    @PostMapping("/add")
    public ResponseEntity<ProductDTO> insert( @RequestBody ProductForm form){
        return ResponseEntity.ok( service.insert(form)) ;
    }


    // PUT - http://localhost:8080/product/id
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update (@PathVariable Long id, @RequestBody ProductForm form) {
        return ResponseEntity.ok(service.update(id, form));
    }
}
