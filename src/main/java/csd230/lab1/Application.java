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

        LaptopEntity laptop = new LaptopEntity(
                faker.regexify("[A-F0-9]{32}"),
                faker.number().numberBetween(0,100),
                faker.number().numberBetween(128,2048) + "GB"
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
        cart.addProduct(laptop);
        cartRepository.save(cart);

        List<ProductEntity> products = productRepository.findAll();

        System.out.println("CART 1: TESTING CREATE");
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

        System.out.println("CART 2: TESTING UPDATE");

        CartEntity cart2 = new  CartEntity();
        cartRepository.save(cart2);
        cart2.addProduct(book);
        cart2.addProduct(phone);
        cart2.addProduct(laptop);
        cart2.addProduct(discMag);
        cart2.addProduct(magazine);
        cart2.addProduct(ticket);

        List<ProductEntity> products2 = productRepository.findAll();
        System.out.println("Original Cart");
        for(ProductEntity p : products2) {
            System.out.println(p.toString());
        }
        book.setAuthor("Diego MaEl");
        magazine.setTitle("Diego");
        discMag.setTitle("Diego");
        ticket.setDescription("Diego");
        phone.setCarrier("Diego Mobile");
        laptop.setStorageSize("Diego gB");

        List<ProductEntity> updatedProducts = productRepository.findAll();

        System.out.println("Updated Cart");
        for(ProductEntity p : updatedProducts) {

            System.out.println(p.toString());
        }

        CartEntity cart3 = new  CartEntity();
        cartRepository.save(cart3);
        cart3.addProduct(book);
        cart3.addProduct(phone);
        cart3.addProduct(laptop);
        cart3.addProduct(discMag);
        cart3.addProduct(magazine);
        cart3.addProduct(ticket);

        System.out.println("CART 3: TESTING DELETE (will just leave a book)");

        System.out.println("Original Cart before deletes");
        for(ProductEntity p : cart3.getProducts()) {
            System.out.println(p.toString());
        }

        cart3.removeProduct(magazine);
        cart3.removeProduct(laptop);
        cart3.removeProduct(phone);
        cart3.removeProduct(discMag);
        cart3.removeProduct(ticket);
        cartRepository.save(cart3);

        System.out.println("Final Cart after deletes");
        for(ProductEntity p : cart3.getProducts()) {
            System.out.println(p.toString());
        }

    }
}