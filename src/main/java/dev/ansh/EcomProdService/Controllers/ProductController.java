package dev.ansh.EcomProdService.Controllers;

import dev.ansh.EcomProdService.Entity.Product;
import dev.ansh.EcomProdService.Service.ProductService;
import dev.ansh.EcomProdService.dto.FakeStoreProductResponseDTO;
import dev.ansh.EcomProdService.exception.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    @Qualifier("ProductService")
    private ProductService productService;

    @GetMapping
    public ResponseEntity getAllProducts() {
       List<Product> products = productService.getAllProducts();
       return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductbyId(@PathVariable("id") UUID id)
    {
        if(id==null)
        {
            throw new InvalidInputException("Input is not correct");
        }
        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product)
    {
        Product savedProduct = productService.createProduct(product);
        return ResponseEntity.ok(savedProduct);
    }


    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") UUID id, @RequestBody Product product)
    {
        Product updatedProduct = productService.updateProduct(product,id);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") UUID id) {

        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @GetMapping("/name/{productName}")
    public ResponseEntity getProductByProductName(@PathVariable("productName") String productName) {

        return ResponseEntity.ok(productService.getProduct(productName));
    }

    @GetMapping("/{min}/{max}")
    public ResponseEntity getProductsByPriceRange(@PathVariable("min") Double minPrice,@PathVariable("max") Double maxPrice) {

        return ResponseEntity.ok(productService.getProducts(minPrice,maxPrice));
    }


}
