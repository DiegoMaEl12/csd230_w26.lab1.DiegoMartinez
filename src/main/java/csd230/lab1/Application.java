package csd230.lab1;

import com.github.javafaker.Commerce;
import com.github.javafaker.Faker;
import csd230.lab1.entities.*;
import csd230.lab1.repositories.CartEntityRepository;
import csd230.lab1.repositories.ProductEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private final ProductEntityRepository productRepository;
    private final CartEntityRepository cartRepository;

    public Application(
            ProductEntityRepository productRepository,
            CartEntityRepository cartRepository
    ) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) {


        String[] carriers = {
                "Verizon", "AT&T", "T-Mobile", "Sprint",
                "Rogers", "Bell", "Telus",
                "Vodafone", "Orange", "O2"
        };

        Faker faker = new Faker();

        BookEntity book = new BookEntity(
                faker.book().title(),
                Double.parseDouble(faker.commerce().price()),
                faker.number().numberBetween(1, 20),
                faker.book().author(),
                faker.number().digits(13)
        );

        MagazineEntity magazine = new MagazineEntity(
                faker.lorem().word() + " Magazine",
                Double.parseDouble(faker.commerce().price()),
                faker.number().numberBetween(1, 20),
                faker.number().numberBetween(1,50),
                LocalDateTime.now()
        );

        DiscMagEntity discMag = new DiscMagEntity(
                faker.lorem().word() + " Disc Magazine",
                Double.parseDouble(faker.commerce().price()),
                faker.number().numberBetween(1, 20),
                faker.number().numberBetween(1,50),
                LocalDateTime.now(),
                faker.bool().bool()
        );

        TicketEntity ticket = new TicketEntity(
                faker.lorem().sentence(),
                Double.parseDouble(faker.commerce().price())
        );

        PhoneEntity phone = new PhoneEntity(
                faker.regexify("[A-F0-9]{32}"),
                faker.number().numberBetween(0,100),
                carriers[faker.number().numberBetween(0, carriers.length - 1)]
        );

        CartEntity cart = new CartEntity();
        cartRepository.save(cart);

        cart.addProduct(book);
        cartRepository.save(cart);
        cart.addProduct(magazine);
        cartRepository.save(cart);
        cart.addProduct(discMag);
        cartRepository.save(cart);
        cart.addProduct(ticket);
        cartRepository.save(cart);
        cart.addProduct(phone);
        cartRepository.save(cart);

        List<ProductEntity> products = productRepository.findAll();

        for(ProductEntity p : products) {
            System.out.println(p.toString());
        }
        List<CartEntity> allCarts = cartRepository.findAll();
        for(CartEntity c : allCarts) {
            System.out.println(c.toString());
            for(ProductEntity p : c.getProducts()) {
                System.out.println(" - " + p.toString());
            }
        }
    }
}