package be.technifutur.product.utils;

import be.technifutur.product.models.entities.Category;
import be.technifutur.product.models.entities.Product;
import be.technifutur.product.repositories.CategoryRepository;
import be.technifutur.product.repositories.ProductRepository;
import be.technifutur.product.repositories.StockRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DatabaseFiller implements InitializingBean {

    private final ProductRepository productRepository;
    private final StockRepository stockRepository;
    private final CategoryRepository categoryRepository;

    public DatabaseFiller(ProductRepository productRepository, StockRepository stockRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.stockRepository = stockRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void afterPropertiesSet() {

        Category category = Category.builder()
                .name("Alimentaire")
                .build();

        categoryRepository.save(category);

        Product product = Product.builder()
                .name("Carotte")
                .brand("fermier")
                .category(category)
                .reference(UUID.randomUUID())
                .price(3)
                .build();

        productRepository.save(product);

        product = Product.builder()
                .name("Patate")
                .brand("fermier")
                .category(category)
                .reference(UUID.randomUUID())
                .price(2.5)
                .build();

        productRepository.save(product);

        category = Category.builder()
                .name("Vêtements")
                .build();

        categoryRepository.save(category);

        product = Product.builder()
                .name("Chemise à pois")
                .brand("H&M")
                .category(category)
                .reference(UUID.randomUUID())
                .price(25)
                .build();

        productRepository.save(product);

    }
}
