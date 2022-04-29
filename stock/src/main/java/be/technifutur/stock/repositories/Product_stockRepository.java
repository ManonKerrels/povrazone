package be.technifutur.stock.repositories;

import be.technifutur.stock.models.entities.Product_stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Product_stockRepository extends JpaRepository<Product_stock, Long> {
}
