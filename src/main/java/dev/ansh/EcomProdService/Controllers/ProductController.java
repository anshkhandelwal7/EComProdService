package dev.ansh.EcomProdService.Controllers;

import dev.ansh.EcomProdService.Entity.Product;
import dev.ansh.EcomProdService.Service.ProductService;
import dev.ansh.EcomProdService.dto.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity getAllProducts() {
       List<FakeStoreProductResponseDTO> products = productService.getAllProducts();
       return ResponseEntity.ok(products);
    }

}
