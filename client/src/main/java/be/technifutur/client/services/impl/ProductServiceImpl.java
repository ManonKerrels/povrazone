package be.technifutur.client.services.impl;

import be.technifutur.client.exceptions.UUIDNotFoundException;
import be.technifutur.client.models.dtos.ProductDTO;
import be.technifutur.client.models.entities.Product;
import be.technifutur.client.models.forms.ProductForm;
import be.technifutur.client.repos.ProductRepository;
import be.technifutur.client.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService
{
    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo)
    {
        this.repo = repo;
    }

    @Override
    public ProductDTO insert(ProductForm form)
    {
        return ProductDTO.of(repo.save(form.toProduct()));
    }

    @Override
    public ProductDTO updateByUUID(UUID ref, ProductForm form)
    {
        Product p = repo.findByReference(ref).orElseThrow(() -> new UUIDNotFoundException(ref));

        p.setName(form.getName());

        return ProductDTO.of(repo.save(p));
    }

    @Override
    public ProductDTO deleteByUUID(UUID ref)
    {
        Product p = repo.findByReference(ref).orElseThrow(() -> new UUIDNotFoundException(ref));

        repo.deleteById(p.getId());

        return ProductDTO.of(p);
    }
}
