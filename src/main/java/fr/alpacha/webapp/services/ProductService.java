package fr.alpacha.webapp.services;

import fr.alpacha.webapp.dao.ProductDao;
import fr.alpacha.webapp.entity.Product;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product createProduct(Product product) {
        return productDao.save(product);
    }

    public Product getProductById(Long id) {
        return productDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id : " + id));
    }

    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id : " + id));

        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setImage(productDetails.getImage());

        return productDao.save(product);
    }

    public void deleteProduct(Long id) {
        productDao.deleteById(id);
    }
}
