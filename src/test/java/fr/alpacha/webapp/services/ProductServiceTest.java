package fr.alpacha.webapp.services;

import fr.alpacha.webapp.entity.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@Transactional
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testGetAllProducts() {
        List<Product> allProducts = productService.getAllProducts();
        assertNotNull(allProducts);
        assertFalse(allProducts.isEmpty());

        Product product = allProducts.get(0);
        assertEquals("pull violet", product.getName());
        assertEquals(29.99, product.getPrice());
        assertEquals("image", product.getImage());
    }

    @Test
    public void testCreateProduct() {
        Product product = new Product();
        product.setName("pull rouge");
        product.setPrice(39.99);
        product.setImage("image2");

        Product createdProduct = productService.createProduct(product);
        assertEquals("pull rouge", createdProduct.getName());
        assertEquals(39.99, createdProduct.getPrice());
        assertEquals("image2", createdProduct.getImage());

        List<Product> allProducts = productService.getAllProducts();
        printAllProducts();
        assertEquals(2, allProducts.size());
    }

    @Test
    public void testGetProductById() {
        Product product = productService.getAllProducts().get(0);
        Product foundProduct = productService.getProductById(product.getId());

        assertEquals(product.getId(), foundProduct.getId());
        assertEquals(product.getName(), foundProduct.getName());
        assertEquals(product.getPrice(), foundProduct.getPrice());
        assertEquals(product.getImage(), foundProduct.getImage());
    }

    @Test
    public void testUpdateProduct() {
        Product product = productService.getAllProducts().get(0);
        Product updatedDetails = new Product();
        updatedDetails.setName("pull vert");
        updatedDetails.setPrice(49.99);
        updatedDetails.setImage("image3");

        Product updatedProduct = productService.updateProduct(product.getId(), updatedDetails);
        assertEquals("pull vert", updatedProduct.getName());
        assertEquals(49.99, updatedProduct.getPrice());
        assertEquals("image3", updatedProduct.getImage());
    }

    @Test
    public void testDeleteProduct() {
        Product product = productService.getAllProducts().get(0);
        productService.deleteProduct(product.getId());

        assertThrows(ResourceNotFoundException.class, () -> {
            productService.getProductById(product.getId());
        });
    }

    private void printAllProducts() {
        List<Product> allProducts = productService.getAllProducts();
        System.out.println("Voici la liste des produits : ");
        for (Product product : allProducts) {
            System.out.println(product);
        }
    }
}
