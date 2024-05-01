package dev.ansh.EcomProdService.Controllers;

import dev.ansh.EcomProdService.Entity.Product;
import dev.ansh.EcomProdService.Service.ProductService;
import dev.ansh.EcomProdService.dto.CreateProductRequestDTO;
import dev.ansh.EcomProdService.dto.FakeStoreProductResponseDTO;
import dev.ansh.EcomProdService.dto.ProductResponseDTO;
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
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
       List<ProductResponseDTO> products = productService.getAllProducts();
       return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductbyId(@PathVariable("id") UUID id)
    {
        if(id==null)
        {
            throw new InvalidInputException("Input is not correct");
        }

        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody CreateProductRequestDTO productRequestDTO)
    {
        return ResponseEntity.ok(productService.createProduct(productRequestDTO));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable("id") UUID id, @RequestBody CreateProductRequestDTO productRequestDTO)
    {
        return ResponseEntity.ok(productService.updateProduct(productRequestDTO,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") UUID id) {

        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @GetMapping("/name/{productName}")
    public ResponseEntity<ProductResponseDTO> getProductByProductName(@PathVariable("productName") String productName) {

        return ResponseEntity.ok(productService.getProduct(productName));
    }

    @GetMapping("/{min}/{max}")
    public ResponseEntity getProductsByPriceRange(@PathVariable("min") Double minPrice,@PathVariable("max") Double maxPrice) {

        return ResponseEntity.ok(productService.getProducts(minPrice,maxPrice));
    }


}
