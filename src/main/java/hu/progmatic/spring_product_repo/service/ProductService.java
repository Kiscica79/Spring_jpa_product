package hu.progmatic.spring_product_repo.service;

import hu.progmatic.spring_product_repo.model.Product;
import hu.progmatic.spring_product_repo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // localhost:8080/products -> összes
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // localhost:8080/products/2 -> 2-es ID
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }


}
