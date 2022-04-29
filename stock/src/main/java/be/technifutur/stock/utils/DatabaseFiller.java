package be.technifutur.stock.utils;

import be.technifutur.stock.models.entities.Delivery;
import be.technifutur.stock.models.entities.Stock;
import be.technifutur.stock.models.entities.Supplier;
import be.technifutur.stock.repositories.DeliveryRepository;
import be.technifutur.stock.repositories.StockRepository;
import be.technifutur.stock.repositories.SupplierRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class DatabaseFiller implements InitializingBean {

    private final StockRepository repository;
    private final SupplierRepository supplierRepository;
    private final DeliveryRepository deliveryRepository;

    public DatabaseFiller(StockRepository repository, SupplierRepository supplierRepository, DeliveryRepository deliveryRepository) {
        this.repository = repository;
        this.supplierRepository = supplierRepository;
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.setUpStock();
    }

    private void setUpStock() throws Exception{

        Stock s = Stock.builder()
                .currentStock(200)
                .reference(UUID.randomUUID())
//                .product_stock(null)
//                .deliveries(null)
                .build();
        repository.save(s);

        Stock s1 = Stock.builder()
                .currentStock(50)
                .reference(UUID.randomUUID())
//                .product_stock(null)
//                .deliveries(null)
                .build();
        repository.save(s1);

        Stock s2 = Stock.builder()
                .currentStock(666)
                .reference(UUID.randomUUID())
//                .product_stock(new Product_stock())
//                .deliveries(null)
                .build();
        repository.save(s2);

        Supplier supplier = Supplier.builder()
                .name("AliBaba")
                .address("Rue des rêves 3")
                .build();
        supplierRepository.save(supplier);

        Delivery delivery = Delivery.builder()
                .dateDelivery(LocalDate.of(2022, 04, 30))
                .stock(s)
                .supplier(supplier)
                .build();
        deliveryRepository.save(delivery);
    }

}
