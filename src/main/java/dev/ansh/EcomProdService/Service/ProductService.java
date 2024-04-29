package dev.ansh.EcomProdService.Service;

import dev.ansh.EcomProdService.Entity.Product;
import dev.ansh.EcomProdService.dto.FakeStoreProductResponseDTO;
import dev.ansh.EcomProdService.exception.ProductNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProduct(UUID productId) throws ProductNotFoundException;
    Product createProduct(Product product);
    Product updateProduct(Product updatedproduct, UUID productId);
    boolean deleteProduct(UUID productId);
    Product getProduct(String productName);
    List<Product> getProducts(double minPrice, double maxPrice);

}
