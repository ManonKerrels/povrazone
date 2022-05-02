package be.technifutur.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.order.models.entities.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct,Long> {

    void deleteByIdIdOrderAndIdIdProduct(Long idOrder, Long idProduct);
    
}
