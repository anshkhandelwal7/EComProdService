package dev.ansh.EcomProdService.mapper;

import dev.ansh.EcomProdService.Entity.Product;
import dev.ansh.EcomProdService.dto.ProductResponseDTO;

public class ProductEntityDTOMapper {
    public static ProductResponseDTO convertProductEntityToProductResponseDTO(Product product) {
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setTitle(product.getTitle());
        responseDTO.setDescription(product.getDescription());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setCategory(product.getCategory());
        responseDTO.setRating(product.getRating());
        responseDTO.setImageURL(product.getImageURL());
        return responseDTO;
    }
}
