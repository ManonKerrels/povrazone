package be.technifutur.order.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.technifutur.models.dtos.OrderDTO;
import be.technifutur.order.models.entities.Order;
import be.technifutur.order.models.entities.OrderProduct;
import be.technifutur.order.models.entities.OrderProductKey;
import be.technifutur.models.forms.OrderForm;
import be.technifutur.models.forms.ProductForm;
import be.technifutur.order.repositories.*;
import be.technifutur.order.services.OrderService;
import be.technifutur.order.services.mapper.OrderMapper;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductRepository productRepos;
    @Autowired
    private OrderProductRepository orderProductRepos;
    @Autowired
    private OrderMapper mapper;

    @Override
    public OrderDTO getOne(Long id) {
        return orderRepository.findById(id).map(mapper::toDto).orElseThrow();
    }

    @Override
    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public OrderDTO insert(OrderForm form) {
        // Order order = Order.builder()
        //     .referenceOrder(UUID.randomUUID())
        //     .orderDate(form.getOrderDate())
        //     .priceTotal(form.getPriceTotal())
        //     //.orderProducts(form.getOrderProducts())
        //     .build();
        Order order = mapper.toEntity(form);
        if(form.getClientId() != null){
            order.setClient(clientRepository.findById(form.getClientId()).orElseThrow());
        }
        
        order = orderRepository.save(order);

        OrderProduct orderProduct = null;
        for (ProductForm proForm : form.getProducts()) {
            orderProduct = OrderProduct.builder()
            .id(new OrderProductKey())
            .order(order)
            .quantity(proForm.getQuantity())
            .shippingDate(proForm.getShippingDate())
            .build();
            if(proForm.getId() != null){
                orderProduct.setProduct(productRepos.findById(proForm.getId()).orElseThrow());
            }

            orderProductRepos.save(orderProduct);
        }
        

        
        //return OrderDTO.of(order);
        return mapper.toDto(order);
    }

    @Override
    public OrderDTO update(Long id, OrderForm form) {
        Order order = orderRepository.findById(id).orElseThrow();
        order.setOrderDate(form.getOrderDate());
        order.setPriceTotal(form.getPriceTotal());
        //order.setOrderProducts(form.getOrderProducts());

        orderRepository.save(order);

        for (OrderProduct orderProduct : order.getOrderProducts()) {
            orderProductRepos.deleteByIdIdOrderAndIdIdProduct(orderProduct.getId().getIdOrder(),orderProduct.getId().getIdProduct());
        }

        OrderProduct orderProduct = null;
        for (ProductForm proForm : form.getProducts()) {
            orderProduct = OrderProduct.builder()
            .id(new OrderProductKey())
            .order(order)
            .quantity(proForm.getQuantity())
            .shippingDate(proForm.getShippingDate())
            .build();
            if(proForm.getId() != null){
                orderProduct.setProduct(productRepos.findById(proForm.getId()).orElseThrow());
            }

            orderProductRepos.save(orderProduct);
        }

        //return OrderDTO.of(order);
        return mapper.toDto(order);
    }

    @Override
    public OrderDTO delete(Long id) {
        Order order = orderRepository.findById(id).orElseThrow();
        for (OrderProduct orderProduct : order.getOrderProducts()) {
            orderProductRepos.deleteByIdIdOrderAndIdIdProduct(orderProduct.getId().getIdOrder(),orderProduct.getId().getIdProduct());
        }
        orderRepository.deleteById(id);
        // return OrderDTO.of(order);
        return mapper.toDto(order);
    }
    
}
