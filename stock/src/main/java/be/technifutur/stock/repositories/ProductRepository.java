package be.technifutur.stock.repositories;

import be.technifutur.stock.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Long> {
    <T> Optional<T> findByUUID(UUID reference);
}
