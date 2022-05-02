package be.technifutur.order.services;

import java.util.List;

import be.technifutur.order.models.dtos.OrderDTO;
import be.technifutur.order.models.forms.OrderForm;

public interface OrderService {
    OrderDTO getOne(Long id);

    List<OrderDTO> getAll();

    OrderDTO insert(OrderForm form);
    OrderDTO update(Long id, OrderForm form);

    OrderDTO delete(Long id);
}
