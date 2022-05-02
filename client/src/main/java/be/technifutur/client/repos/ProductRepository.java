package be.technifutur.client.repos;

import be.technifutur.client.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{
    public Optional<Product> findByReference(UUID uuid);
}
