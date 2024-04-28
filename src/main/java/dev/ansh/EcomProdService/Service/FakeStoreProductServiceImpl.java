package dev.ansh.EcomProdService.Service;

import dev.ansh.EcomProdService.Entity.Product;
import dev.ansh.EcomProdService.client.FakeStoreClient;
import dev.ansh.EcomProdService.dto.FakeStoreProductResponseDTO;
import dev.ansh.EcomProdService.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("fakeStoreProductServiceImpl")
public class FakeStoreProductServiceImpl implements ProductService{

    private FakeStoreClient fakeStoreClient;
    @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts= fakeStoreClient.getAllProducts();
        return fakeStoreProducts;
    }

    @Override
    public FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO=fakeStoreClient.getProductbyId(productId);
        if(fakeStoreProductResponseDTO==null)
        {
            throw new ProductNotFoundException("Product not found with id" + productId);
        }
        return fakeStoreProductResponseDTO;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
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
