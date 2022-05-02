package be.technifutur.client.controllers;

import be.technifutur.client.models.dtos.ProductDTO;
import be.technifutur.client.models.forms.ProductForm;
import be.technifutur.client.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController
{
    private final ProductService service;

    public ProductController(ProductService service)
    {
        this.service = service;
    }


    @PostMapping
    public ProductDTO insert(@RequestBody ProductForm form)
    {
        return service.insert(form);
    }

    @DeleteMapping
    public ProductDTO delete(@RequestBody ProductForm form)
    {
        return service.deleteByUUID(form.getReference());
    }

    @PutMapping
    public ProductDTO update(@RequestBody ProductForm form)
    {
        return service.updateByUUID(form.getReference(), form);
    }
}
