package dev.ansh.EcomProdService.mapper;

import dev.ansh.EcomProdService.Entity.Product;
import dev.ansh.EcomProdService.dto.CreateProductRequestDTO;
import dev.ansh.EcomProdService.dto.ProductResponseDTO;

public class ProductEntityDTOMapper {
    public static ProductResponseDTO convertProductEntityToProductResponseDTO(Product product) {
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setTitle(product.getTitle());
        responseDTO.setDescription(product.getDescription());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setRating(product.getRating());
        responseDTO.setImageURL(product.getImageURL());
        responseDTO.setCategory(product.getCategory().getName());
        return responseDTO;
    }

    public static Product convertCreateProductRequestDTOToProduct(CreateProductRequestDTO productRequestDTO){
        Product product = new Product();
        product.setTitle(productRequestDTO.getTitle());
        product.setRating(0);
        product.setPrice(productRequestDTO.getPrice());
        product.setImageURL(productRequestDTO.getImageURL());
        product.setDescription(productRequestDTO.getDescription());
        return product;
    }
}
