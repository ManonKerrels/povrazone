package be.technifutur.order.services.mapper;

import org.springframework.stereotype.Service;

import be.technifutur.models.dtos.OrderDTO;
import be.technifutur.models.forms.OrderForm;
import be.technifutur.order.models.entities.Order;

@Service
public class OrderMapper {
    public OrderDTO toDto(Order order){
        if(order == null)
            return null;

        return new OrderDTO(order.getId(),order.getOrderDate(), order.getPriceTotal(), order.getReferenceOrder());
    }

    public Order toEntity(OrderForm form){
        if(form == null)
            return null;
        
        return Order.builder()
            .orderDate(form.getOrderDate())
            .priceTotal(form.getPriceTotal())
            .build();
    }
}
