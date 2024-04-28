package dev.ansh.EcomProdService.Controllers;

import dev.ansh.EcomProdService.Entity.Product;
import dev.ansh.EcomProdService.Service.ProductService;
import dev.ansh.EcomProdService.dto.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    @Qualifier("ProductService")
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity getAllProducts() {
       List<FakeStoreProductResponseDTO> products = productService.getAllProducts();
       return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProductbyId(@PathVariable("id") int id)
    {
        FakeStoreProductResponseDTO product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/product")
    public ResponseEntity createProduct(@RequestBody Product product)
    {
        Product savedProduct = productService.createProduct(product);
        return ResponseEntity.ok(savedProduct);
    }


}
