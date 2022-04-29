package be.technifutur.stock.utils;

import be.technifutur.stock.models.entities.Product_stock;
import be.technifutur.stock.models.entities.Stock;
import be.technifutur.stock.repositories.StockRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DatabaseFiller implements InitializingBean {

    private final StockRepository repository;

    public DatabaseFiller(StockRepository repository) {
        this.repository = repository;
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

        s = Stock.builder()
                .currentStock(50)
                .reference(UUID.randomUUID())
//                .product_stock(null)
//                .deliveries(null)
                .build();
        repository.save(s);

        s = Stock.builder()
                .currentStock(666)
                .reference(UUID.randomUUID())
//                .product_stock(new Product_stock())
//                .deliveries(null)
                .build();
        repository.save(s);
    }

}
