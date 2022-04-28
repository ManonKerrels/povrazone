package be.technifutur.product.repositories;

import be.technifutur.product.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
