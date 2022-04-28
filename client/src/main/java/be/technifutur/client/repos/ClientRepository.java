package be.technifutur.client.repos;

import be.technifutur.client.models.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long>
{
}
