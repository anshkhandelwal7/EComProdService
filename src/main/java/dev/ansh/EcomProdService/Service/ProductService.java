package dev.ansh.EcomProdService.Service;

import dev.ansh.EcomProdService.Entity.Product;
import dev.ansh.EcomProdService.dto.FakeStoreProductResponseDTO;
import dev.ansh.EcomProdService.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    List<FakeStoreProductResponseDTO> getAllProducts();
    FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException;
    Product createProduct(Product product);
    Product updateProduct(Product updatedproduct, int productId);
    boolean deleteProduct(int productId);

}
