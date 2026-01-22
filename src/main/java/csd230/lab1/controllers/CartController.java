package csd230.lab1.controllers;
import csd230.lab1.entities.*;
import csd230.lab1.repositories.BookEntityRepository;
import csd230.lab1.repositories.CartEntityRepository;
import csd230.lab1.repositories.OrderEntityRepository;
import csd230.lab1.repositories.PublicationEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartEntityRepository cartRepository;

    @Autowired
    private BookEntityRepository bookRepository;

    @Autowired
    private OrderEntityRepository orderRepository;

    @Autowired
    private PublicationEntityRepository publicationRepository;

    // 1. View the contents of the cart
    @GetMapping
    public String viewCart(Model model) {
        // HARDCODED ID: In a real app, this comes from the Session or SecurityContext
        Long defaultCartId = 1L;

        // Find cart with ID 1, or create a temporary empty one if not found
        CartEntity cart = cartRepository.findById(defaultCartId)
                .orElseGet(() -> {
                    CartEntity newCart = new CartEntity();
                    newCart.setId(defaultCartId);
                    return cartRepository.save(newCart); // Save it so it exists
                });
        model.addAttribute("cart", cart);
        return "cartDetails";
    }

    // 2. Add a specific book to the cart
    @GetMapping("/add/{bookId}")
    public String addToCart(@PathVariable Long bookId) {
        Long defaultCartId = 1L;
        CartEntity cart = cartRepository.findById(defaultCartId).orElse(null);
        BookEntity book = bookRepository.findById(bookId).orElse(null);
        if (cart != null && book != null) {
            cart.addProduct(book); // Uses the helper method in CartEntity
            cartRepository.save(cart); // Updates the Join Table
        }
        return "redirect:/books"; // Send them back to the shopping list
    }

    // 3. Remove item from cart
    @GetMapping("/remove/{bookId}")
    public String removeFromCart(@PathVariable Long bookId) {
        Long defaultCartId = 1L;
        CartEntity cart = cartRepository.findById(defaultCartId).orElse(null);
        BookEntity book = bookRepository.findById(bookId).orElse(null);
        if(cart != null && book != null) {
            cart.getProducts().remove(book);
            cartRepository.save(cart);
        }
        return "redirect:/cart";
    }

    @PostMapping("/checkout")
    public String checkoutCart() {

        CartEntity cart = cartRepository.findById(1L).orElse(null);

        if(cart == null || cart.getProducts().isEmpty()) {
            return "redirect:/cart";
        }

        OrderEntity order = new OrderEntity();
        order.setOrderDate(java.time.LocalDateTime.now());

        double total = 0.0;
        for(var product : cart.getProducts()) {

            total += product.getPrice();

            if(product instanceof PublicationEntity publication) {
                if(publication.getCopies() <= 0 ) {
                    return "redirect:/books?error=out-of-stock";
                }
                else{
                    publication.setCopies(publication.getCopies() - 1);
                    publicationRepository.save(publication);
                }
            }
            order.getProducts().add(product);
        }
        order.setTotalAmount(total);
        OrderEntity  savedOrder = orderRepository.save(order);


        for (var product : new HashSet<>(cart.getProducts())) {
            cart.removeProduct(product);
        }

        cartRepository.save(cart);
        return "redirect:/orders/" +  savedOrder.getId();
    }
}
