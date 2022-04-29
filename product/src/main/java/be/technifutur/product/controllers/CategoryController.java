package be.technifutur.product.controllers;

import be.technifutur.product.business.services.CategoryService;
import be.technifutur.product.models.dto.CategoryDTO;
import be.technifutur.product.models.forms.CategoryForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    // GET - http://localhost:8080/category
    @GetMapping
    public List<CategoryDTO> getAll(){
        return service.getAll();
    }


    // GET - http://localhost:8080/category/id
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getOne (@PathVariable Long id){
        return ResponseEntity.ok(service.getOne(id));
    }



    // DELETE -  http://localhost:8080/category/id
    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }


    // POST -http://localhost:8080/category/add
    @PostMapping("/add")
    public ResponseEntity<CategoryDTO> insert( @RequestBody CategoryForm form){
        return ResponseEntity.ok( service.insert(form)) ;
    }


    // PUT - http://localhost:8080/category/id
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update (@PathVariable Long id, @RequestBody CategoryForm form) {
        return ResponseEntity.ok(service.update(id, form));
    }
}
