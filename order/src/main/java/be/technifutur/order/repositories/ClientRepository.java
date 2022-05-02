package be.technifutur.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.order.models.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
