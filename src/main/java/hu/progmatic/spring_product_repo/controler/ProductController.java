package hu.progmatic.spring_product_repo.controler;

import hu.progmatic.spring_product_repo.model.Product;
import hu.progmatic.spring_product_repo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @Responsebody (json)
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping // localhost: 8080/products
    public List<Product> showAllProducts() {
        return productService.getAllProducts();
    }

    // localhost: 8080/songs/2
    @GetMapping("/{id}")
    public Product showSongById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // THIS IS NOT THE WAY EITHER
    @GetMapping("/create") // http://localhost:8080/products/create?name=sajtostaller&price=10
    public Product createProductByRequestParam(@RequestParam String name, @RequestParam Integer price) {
        return productService.createProduct(new Product(name, price));
    }

    // THIS IS NOT THE WAY
    @GetMapping("/create/{name}/{price}") // http://localhost:8080/products/create/kandallo/5
    public Product createProductByPathVariable(@PathVariable String name, @PathVariable Integer price) {
        return productService.createProduct(new Product(name, price));
    }

    // This is the way
    @PostMapping
    public Product addNewProducts(@RequestBody Product product) {
        return productService.createProduct(product);
    }

}
