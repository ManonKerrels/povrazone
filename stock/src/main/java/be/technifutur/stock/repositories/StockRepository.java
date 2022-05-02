package be.technifutur.stock.repositories;

import be.technifutur.stock.models.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
