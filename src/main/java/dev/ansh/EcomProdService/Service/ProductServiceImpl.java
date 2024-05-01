package dev.ansh.EcomProdService.Service;

import dev.ansh.EcomProdService.Entity.Category;
import dev.ansh.EcomProdService.Entity.Product;
import dev.ansh.EcomProdService.dto.CreateProductRequestDTO;
import dev.ansh.EcomProdService.dto.FakeStoreProductResponseDTO;
import dev.ansh.EcomProdService.dto.ProductResponseDTO;
import dev.ansh.EcomProdService.exception.CategoryNotFoundException;
import dev.ansh.EcomProdService.exception.ProductNotFoundException;
import dev.ansh.EcomProdService.mapper.ProductEntityDTOMapper;
import dev.ansh.EcomProdService.repository.CategoryRepository;
import dev.ansh.EcomProdService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("ProductService")
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> savedProducts = productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();
        for(Product product : savedProducts )
        {
            productResponseDTOs.add(ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product));
        }
        return productResponseDTOs;
    }

    @Override
    public ProductResponseDTO getProduct(UUID productId) throws ProductNotFoundException {
//        Product savedProduct=productRepository.findById(productId).get();
//        if(savedProduct==null)
//            throw new ProductNotFoundException("Product Not Found for id "+productId);
//    return savedProduct;

        Product product = productRepository.findById(productId).orElseThrow(
                ()-> new ProductNotFoundException("Product Not Found for id: " + productId)
        );
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO createProduct(CreateProductRequestDTO productRequestDTO) {
        Product product= ProductEntityDTOMapper.convertCreateProductRequestDTOToProduct(productRequestDTO);
        Category category= categoryRepository.findById(productRequestDTO.getCategoryId()).orElseThrow(
                ()-> new CategoryNotFoundException(("Category Not Found for id: " + productRequestDTO.getCategoryId()))
        );
        product.setCategory(category);
        product=productRepository.save(product);
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO updateProduct(CreateProductRequestDTO createProductRequestDTO, UUID productId) {
       Product savedProduct = productRepository.findById(productId).orElseThrow(
               ()-> new ProductNotFoundException("Product Not Found for id: " + productId));
       savedProduct.setTitle(createProductRequestDTO.getTitle());
       savedProduct.setDescription(createProductRequestDTO.getDescription());
       savedProduct.setPrice(createProductRequestDTO.getPrice());
       savedProduct.setImageURL(createProductRequestDTO.getImageURL());
       return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(savedProduct);

    }

    @Override
    public boolean deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public ProductResponseDTO getProduct(String productName) {
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(productRepository.findProductByTitle(productName));
    }

    @Override
    public List<Product> getProducts(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }


}
