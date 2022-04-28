package be.technifutur.client.repos;

import be.technifutur.client.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>
{
}
