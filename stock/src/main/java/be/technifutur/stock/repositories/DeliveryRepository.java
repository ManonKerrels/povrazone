package be.technifutur.stock.repositories;

import be.technifutur.stock.models.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Long, Delivery> {
}
