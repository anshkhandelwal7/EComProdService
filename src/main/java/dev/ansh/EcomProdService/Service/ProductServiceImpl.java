package dev.ansh.EcomProdService.Service;

import dev.ansh.EcomProdService.Entity.Product;
import dev.ansh.EcomProdService.dto.FakeStoreProductResponseDTO;
import dev.ansh.EcomProdService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ProductService")
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public FakeStoreProductResponseDTO getProduct(int productId) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product updateProduct(Product updatedproduct, int productId) {
        return null;
    }

    @Override
    public boolean deleteProduct(int productId) {
        return false;
    }
}
