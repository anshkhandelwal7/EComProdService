package dev.ansh.EcomProdService.Service;

import dev.ansh.EcomProdService.Entity.Product;
import dev.ansh.EcomProdService.client.FakeStoreClient;
import dev.ansh.EcomProdService.dto.FakeStoreProductResponseDTO;
import dev.ansh.EcomProdService.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("fakeStoreProductServiceImpl")
public class FakeStoreProductServiceImpl{

    private FakeStoreClient fakeStoreClient;

    public List<FakeStoreProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts= fakeStoreClient.getAllProducts();
        return fakeStoreProducts;
    }


    public FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO=fakeStoreClient.getProductbyId(productId);
        if(fakeStoreProductResponseDTO==null)
        {
            throw new ProductNotFoundException("Product not found with id" + productId);
        }
        return fakeStoreProductResponseDTO;
    }

    public Product createProduct(Product product) {
        return null;
    }

    public Product updateProduct(Product updatedproduct, int productId) {
        return null;
    }

    public boolean deleteProduct(int productId) {
        return false;
    }
}
