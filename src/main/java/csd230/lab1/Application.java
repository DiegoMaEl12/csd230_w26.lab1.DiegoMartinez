package csd230.lab1;

import csd230.lab1.repositories.CartEntityRepository;
import csd230.lab1.repositories.ProductEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private final ProductEntityRepository productRepository;
    private final CartEntityRepository cartRepository;

    public Application(ProductEntityRepository productRepository, CartEntityRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // TODO add the logic of the CRUD operations on all the entities
        //  TODO Add the queries required by the lab assignment in all the other repos.
    }
}
