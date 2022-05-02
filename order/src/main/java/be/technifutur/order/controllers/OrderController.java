package be.technifutur.order.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import be.technifutur.order.models.dtos.OrderDTO;
import be.technifutur.order.models.forms.OrderForm;
import be.technifutur.order.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOne(@PathVariable Long id){
        return ResponseEntity.ok(service.getOne(id));
    }

    @PostMapping("/add")
    public ResponseEntity<OrderDTO> insert(@RequestBody OrderForm form){
        return ResponseEntity.ok(service.insert(form));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> update(@PathVariable Long id, @RequestBody OrderForm form){
        return ResponseEntity.ok(service.update(id,form));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }
}
