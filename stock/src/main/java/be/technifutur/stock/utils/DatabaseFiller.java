package be.technifutur.stock.utils;

import be.technifutur.stock.models.entities.Delivery;
import be.technifutur.stock.models.entities.Product;
import be.technifutur.stock.models.entities.Stock;
import be.technifutur.stock.models.entities.Supplier;
import be.technifutur.stock.repositories.DeliveryRepository;
import be.technifutur.stock.repositories.ProductRepository;
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
    private final ProductRepository productRepository;

    public DatabaseFiller(StockRepository repository, SupplierRepository supplierRepository, DeliveryRepository deliveryRepository, ProductRepository productRepository) {
        this.repository = repository;
        this.supplierRepository = supplierRepository;
        this.deliveryRepository = deliveryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.setUpStock();
    }

    private void setUpStock() throws Exception{

        //produit
        Product p = Product.builder()
                .name("Carottes")
                .reference(UUID.randomUUID())
                .build();
        productRepository.save(p);

        //stock + association au produit
        Stock s = Stock.builder()
                .currentStock(200)
                .reference(UUID.randomUUID())
//                .product(p)
                .build();
        repository.save(s);
        p.setStock(s);
        productRepository.save(p);

        //produit 1
        Product p1 = Product.builder()
                .name("Tomates")
                .reference(UUID.randomUUID())
                .build();
        productRepository.save(p1);

        //stock 1 + association au produit 1
        Stock s1 = Stock.builder()
                .currentStock(50)
                .reference(UUID.randomUUID())
                .build();
        repository.save(s1);
        p1.setStock(s1);
        productRepository.save(p1);

        //produit 2
        Product p2 = Product.builder()
                .name("Poivrons")
                .reference(UUID.randomUUID())
                .build();
        productRepository.save(p2);

        //stock 2 + association au produit 2
        Stock s2 = Stock.builder()
                .currentStock(666)
                .reference(UUID.randomUUID())
                .build();
        repository.save(s2);
        p2.setStock(s2);
        productRepository.save(p2);

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
