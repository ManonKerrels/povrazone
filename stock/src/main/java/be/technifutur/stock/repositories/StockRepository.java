package be.technifutur.stock.repositories;

import be.technifutur.stock.models.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
