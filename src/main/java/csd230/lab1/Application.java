package csd230.lab1;

import com.github.javafaker.Commerce;
import com.github.javafaker.Faker;
import csd230.lab1.entities.*;
import csd230.lab1.pojos.Laptop;
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

        CartEntity cart = new CartEntity();
        cartRepository.save(cart);

        for (int j = 0; j < 3; j++){

            BookEntity book = new BookEntity(
                    faker.book().title(),
                    Double.parseDouble(faker.commerce().price()),
                    faker.number().numberBetween(1, 20),
                    faker.book().author(),
                    faker.number().digits(13)
            );
            cart.addProduct(book);

            MagazineEntity magazine = new MagazineEntity(
                    faker.lorem().word() + " Magazine",
                    Double.parseDouble(faker.commerce().price()),
                    faker.number().numberBetween(1, 20),
                    faker.number().numberBetween(1,50),
                    LocalDateTime.now()
            );
            cart.addProduct(magazine);

            DiscMagEntity discMag = new DiscMagEntity(
                    faker.lorem().word() + " Disc Magazine",
                    Double.parseDouble(faker.commerce().price()),
                    faker.number().numberBetween(1, 20),
                    faker.number().numberBetween(1,50),
                    LocalDateTime.now(),
                    faker.bool().bool()
            );
            cart.addProduct(discMag);

            TicketEntity ticket = new TicketEntity(
                    faker.lorem().sentence(),
                    faker.number().randomDouble(2, 1, 100L)
            );
            cart.addProduct(ticket);

            PhoneEntity phone = new PhoneEntity(
                    faker.regexify("[A-F0-9]{32}"),
                    faker.number().numberBetween(0,100),
                    carriers[faker.number().numberBetween(0, carriers.length - 1)],
                    faker.number().randomDouble(2,1,100L)
            );
            cart.addProduct(phone);

            LaptopEntity laptop = new LaptopEntity(
                    faker.regexify("[A-F0-9]{32}"),
                    faker.number().numberBetween(0,100),
                    faker.number().numberBetween(128,2048) + "GB",
                    faker.number().randomDouble(2,1,100L)
            );
            cart.addProduct(laptop);

            cartRepository.save(cart);
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