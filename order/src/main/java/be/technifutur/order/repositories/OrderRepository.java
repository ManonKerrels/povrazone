package be.technifutur.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.order.models.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
