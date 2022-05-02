package be.technifutur.order.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.technifutur.order.models.dtos.OrderDTO;
import be.technifutur.order.models.entities.Order;
import be.technifutur.order.models.entities.OrderProduct;
import be.technifutur.order.models.entities.OrderProductKey;
import be.technifutur.order.models.forms.OrderForm;
import be.technifutur.order.repositories.*;
import be.technifutur.order.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductRepository productRepos;
    @Autowired
    private OrderProductRepository orderProductRepos;

    @Override
    public OrderDTO getOne(Long id) {
        return orderRepository.findById(id).map(OrderDTO::of).orElseThrow();
    }

    @Override
    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream().map(OrderDTO::of).toList();
    }

    @Override
    public OrderDTO insert(OrderForm form) {
        Order order = Order.builder()
            .referenceOrder(UUID.randomUUID())
            .orderDate(form.getOrderDate())
            .priceTotal(form.getPriceTotal())
            //.orderProducts(form.getOrderProducts())
            .build();
        if(form.getClientId() != null){
            order.setClient(clientRepository.findById(form.getClientId()).orElseThrow());
        }
        
        order = orderRepository.save(order);

        OrderProduct orderProduct = OrderProduct.builder()
            .id(new OrderProductKey())
            .order(order)
            .quantity(form.getQuantity())
            .shippingDate(form.getShippingDate())
            .build();
        if(form.getProductId() != null){
            orderProduct.setProduct(productRepos.findById(form.getProductId()).orElseThrow());
        }

        orderProductRepos.save(orderProduct);
        return OrderDTO.of(order);
    }

    @Override
    public OrderDTO update(Long id, OrderForm form) {
        Order order = orderRepository.findById(id).orElseThrow();
        order.setOrderDate(form.getOrderDate());
        order.setPriceTotal(form.getPriceTotal());
        //order.setOrderProducts(form.getOrderProducts());

        return OrderDTO.of(orderRepository.save(order));
    }

    @Override
    public OrderDTO delete(Long id) {
        OrderDTO order = getOne(id);
        orderRepository.deleteById(id);
        return order;
    }
    
}
