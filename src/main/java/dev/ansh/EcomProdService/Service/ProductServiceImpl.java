package dev.ansh.EcomProdService.Service;

import dev.ansh.EcomProdService.Entity.Product;
import dev.ansh.EcomProdService.dto.FakeStoreProductResponseDTO;
import dev.ansh.EcomProdService.exception.ProductNotFoundException;
import dev.ansh.EcomProdService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("ProductService")
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public Product getProduct(UUID productId) throws ProductNotFoundException {
//        Product savedProduct=productRepository.findById(productId).get();
//        if(savedProduct==null)
//            throw new ProductNotFoundException("Product Not Found for id "+productId);
//    return savedProduct;

        return productRepository.findById(productId).orElseThrow(
                ()-> new ProductNotFoundException("Product Not Found for id: " + productId)
        );
    }

    @Override
    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product updateProduct(Product updatedproduct, UUID productId) {
       Product savedProduct = productRepository.findById(productId).orElseThrow(
               ()-> new ProductNotFoundException("Product Not Found for id: " + productId));
       savedProduct.setTitle(updatedproduct.getTitle());
       savedProduct.setDescription(updatedproduct.getDescription());
       savedProduct.setPrice(updatedproduct.getPrice());
       savedProduct.setCategory(updatedproduct.getCategory());
       savedProduct.setRating(updatedproduct.getRating());
       savedProduct.setImageURL(updatedproduct.getImageURL());
       return productRepository.save(savedProduct);

    }

    @Override
    public boolean deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public Product getProduct(String productName) {
        return productRepository.findProductByTitle(productName);
    }

    @Override
    public List<Product> getProducts(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }


}
