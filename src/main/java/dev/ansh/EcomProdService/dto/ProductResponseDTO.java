package dev.ansh.EcomProdService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private int productId;
    private String title;
    private String description;
    private double price;
    private String category;
    private String imageURL;
    private double rating;

}
