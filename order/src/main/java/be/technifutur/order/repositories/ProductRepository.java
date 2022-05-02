package be.technifutur.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.order.models.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
    
}
