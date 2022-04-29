package be.technifutur.product.repositories;

import be.technifutur.product.models.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
