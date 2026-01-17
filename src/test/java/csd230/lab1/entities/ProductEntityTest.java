package csd230.lab1.entities;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductEntityTest {

    // Minimal concrete subclass for testing abstract ProductEntity
    static class TestProductEntity extends ProductEntity {
        @Override
        public void sellItem() {
            // no-op for testing
        }
    }

    @Test
    void defaultConstructor_shouldCreateObject() {
        ProductEntity product = new TestProductEntity();
        assertNotNull(product);
    }

    @Test
    void setPrice_shouldUpdatePrice() {
        ProductEntity product = new TestProductEntity();

        product.setPrice(19.99);

        assertEquals(19.99, product.getPrice());
    }

    @Test
    void carts_shouldAllowBidirectionalLinking() {
        ProductEntity product = new TestProductEntity();
        CartEntity cart = new CartEntity();

        cart.addProduct(product);

        assertTrue(product.getCarts().contains(cart));
        assertTrue(cart.getProducts().contains(product));
    }
}
