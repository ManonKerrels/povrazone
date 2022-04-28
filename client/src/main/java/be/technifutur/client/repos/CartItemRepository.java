package be.technifutur.client.repos;

import be.technifutur.client.models.entities.CartItem;
import be.technifutur.client.models.entities.embeddable.CartID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, CartID>
{
}
