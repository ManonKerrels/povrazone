package be.technifutur.product.repositories;

import be.technifutur.product.models.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findByReference(UUID reference);
}
