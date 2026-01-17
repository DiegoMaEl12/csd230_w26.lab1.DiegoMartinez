package csd230.lab1.entities;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CartEntityTest {

    @Test
    void addProduct_shouldAddProductToCart() {
        CartEntity cart = new CartEntity();
        ProductEntity product = new BookEntity(
                "Clean Code",
                49.99,
                5,
                "Robert C. Martin",
                "9780132350884"
        );

        cart.addProduct(product);

        assertEquals(1, cart.getProducts().size());
        assertTrue(cart.getProducts().contains(product));
    }

    @Test
    void addProduct_shouldMaintainBidirectionalRelationship() {
        CartEntity cart = new CartEntity();
        ProductEntity product = new BookEntity(
                "Effective Java",
                59.99,
                3,
                "Joshua Bloch",
                "9780134685991"
        );

        cart.addProduct(product);

        assertTrue(product.getCarts().contains(cart));
    }

    @Test
    void setProducts_shouldReplaceExistingProducts() {
        CartEntity cart = new CartEntity();

        ProductEntity product1 = new BookEntity(
                "Book A",
                10.0,
                1,
                "Author A",
                "111"
        );

        ProductEntity product2 = new BookEntity(
                "Book B",
                20.0,
                2,
                "Author B",
                "222"
        );

        cart.addProduct(product1);
        cart.setProducts(Set.of(product2));

        assertEquals(1, cart.getProducts().size());
        assertTrue(cart.getProducts().contains(product2));
        assertFalse(cart.getProducts().contains(product1));
    }
}
